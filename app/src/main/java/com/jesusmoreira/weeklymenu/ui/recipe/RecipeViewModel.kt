package com.jesusmoreira.weeklymenu.ui.recipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jesusmoreira.weeklymenu.domain.model.Recipe
import com.jesusmoreira.weeklymenu.domain.usecase.recipe.InsertRecipeUseCase


class RecipeViewModel(
    private val insertRecipe: InsertRecipeUseCase? = null,
    private val recipeId: Int? = null
): ViewModel() {
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

    suspend fun onSubmit() {
        if (!_name.value.isNullOrBlank()) {
            if (recipeId != null) {
                // recipeRepository update
            } else {
                insertRecipe?.let { insert -> insert(
                    Recipe(name = _name.value!!, description = _description.value ?: "")
                )}
            }
        }
    }
}