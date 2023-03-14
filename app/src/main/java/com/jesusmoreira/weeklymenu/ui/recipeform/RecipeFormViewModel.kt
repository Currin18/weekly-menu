package com.jesusmoreira.weeklymenu.ui.recipeform

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jesusmoreira.weeklymenu.domain.model.*
import com.jesusmoreira.weeklymenu.domain.usecase.recipe.GetRecipeByIdUseCase
import com.jesusmoreira.weeklymenu.domain.usecase.recipe.InsertRecipeUseCase
import com.jesusmoreira.weeklymenu.domain.usecase.recipe.UpdateRecipeUseCase
import kotlinx.coroutines.launch


class RecipeFormViewModel(
    private val getRecipeById: GetRecipeByIdUseCase? = null,
    private val insertRecipe: InsertRecipeUseCase? = null,
    private val updateRecipe: UpdateRecipeUseCase? = null,
): ViewModel() {
    private val _id = MutableLiveData<Int>()

    private val _title = MutableLiveData("New recipe")
    val title: LiveData<String> = _title

    private val _name = MutableLiveData("")
    val name: LiveData<String> = _name
    fun setName(name: String) { _name.value = name }

    private val _description = MutableLiveData("")
    val description: LiveData<String> = _description
    fun setDescription(description: String) { _description.value = description }

    private val _time = MutableLiveData<Int>(0)
    val time: LiveData<Int> = _time
    fun setTime(time: Int) { _time.value = time }

    private val _difficulty = MutableLiveData(Difficulty.EASY)
    val difficulty: LiveData<Difficulty> = _difficulty
    fun setDifficulty(difficulty: Difficulty) { _difficulty.value = difficulty }

    private val _services = MutableLiveData<Set<Service>>(setOf())
    val services: LiveData<Set<Service>> = _services
    fun setServices(services: Set<Service>) { _services.value = services }

    private val _tags = MutableLiveData<Set<String>>(setOf())
    val tags: LiveData<Set<String>> = _tags
    fun setTags(tags: Set<String>) { _tags.value = tags }

    private val _ingredients = MutableLiveData<List<Ingredient>>(listOf())
    val ingredients: LiveData<List<Ingredient>> = _ingredients
    fun setIngredients(ingredients: List<Ingredient>) { _ingredients.value = ingredients }

    private val _directions = MutableLiveData<List<String>>(listOf())
    val directions: LiveData<List<String>> = _directions
    fun setDirections(directions: List<String>) { _directions.value = directions }

    private val _nutrition = MutableLiveData<Nutrition>()
    val nutrition: LiveData<Nutrition> = _nutrition
    fun setNutrition(nutrition: Nutrition) { _nutrition.value = nutrition }

    fun setRecipeId(recipeId: Int) {
        _id.value = recipeId

        viewModelScope.launch {
            getRecipeById?.let { get ->
                val recipe = _id.value?.let { get(it) }
                recipe?.apply {
                    _title.value = name
                    _name.value = name
                    _description.value = description
                    _time.value = time
                    _difficulty.value = difficulty
                    _services.value = services
                    _tags.value = tags
                    _ingredients.value = ingredients
                    _directions.value = directions
                    _nutrition.value = nutrition
                }
            }
        }
    }

    fun clear() {
        _name.value = ""
        _description.value = ""
        _time.value = 0
        _difficulty.value = Difficulty.EASY
    }

    fun onSubmit() {
        if (_id.value != null) {
            launchUpdate()
        } else {
            launchInsert()
        }
    }

    private fun formRecipe() = Recipe(
        id = _id.value,
        name = _name.value!!,
        description = _description.value!!,
        time = _time.value!!,
        difficulty = _difficulty.value!!,
    )

    private fun launchInsert() {
        viewModelScope.launch {
            insertRecipe?.let { insert -> insert(formRecipe()) }
        }
    }

    private fun launchUpdate() {
        viewModelScope.launch {
            updateRecipe?.let{ update -> update(formRecipe()) }
        }
    }
}