package com.jesusmoreira.weeklymenu.ui.recipeform

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jesusmoreira.weeklymenu.domain.model.Recipe
import com.jesusmoreira.weeklymenu.domain.usecase.recipe.GetRecipeByIdUseCase
import com.jesusmoreira.weeklymenu.domain.usecase.recipe.InsertRecipeUseCase
import kotlinx.coroutines.launch


class RecipeFormViewModel(
    private val getRecipeById: GetRecipeByIdUseCase? = null,
    private val insertRecipe: InsertRecipeUseCase? = null,
): ViewModel() {
    private val _id = MutableLiveData<Int>()

    private val _title = MutableLiveData("New recipe")
    val title: LiveData<String> = _title

    private val _name = MutableLiveData("")
    val name: LiveData<String> = _name

    fun setName(name: String) {
        _name.value = name
    }

    private val _description = MutableLiveData("")
    val description: LiveData<String> = _description

    fun setDescription(description: String) {
        _description.value = description
    }

    fun setRecipeId(recipeId: Int) {
        _id.value = recipeId
        viewModelScope.launch {
            getRecipeById?.let { get ->
                val recipe = _id.value?.let { get(it) }
                recipe?.let {
                    _title.value = it.name
                    _name.value = it.name
                    _description.value = it.description
                }
            }
        }
    }

    fun clear() {
        _name.value = ""
        _description.value = ""
    }

    fun onSubmit(): Boolean {
        var isValidated = true
        if (_name.value.isNullOrBlank()) {
            isValidated = false
        }

        if (isValidated) {
            if (_id.value != null) {
                launchUpdate()
            } else {
                launchInsert()
            }
        }
        return isValidated
    }

    private fun launchInsert() {
        viewModelScope.launch {
            insertRecipe?.let { insert ->
                insert(
                    Recipe(
                        name = _name.value!!,
                        description = _description.value!!
                    )
                )
            }
        }
    }

    private fun launchUpdate() {
        viewModelScope.launch {

        }
    }
}