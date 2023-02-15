package com.jesusmoreira.weeklymenu.ui.cookbook

import androidx.lifecycle.*
import com.jesusmoreira.weeklymenu.domain.model.Recipe
import com.jesusmoreira.weeklymenu.domain.usecase.recipe.GetAllRecipesUseCase
import kotlinx.coroutines.launch

class CookbookViewModel(private val getAllRecipes: GetAllRecipesUseCase?): ViewModel() {
    // private val _recipes = MutableLiveData<List<Recipe>>()
    private val _recipes by lazy {
        MutableLiveData<List<Recipe>>()
    }
    val recipes: LiveData<List<Recipe>> get() = _recipes

    init {
        viewModelScope.launch {
            getAllRecipes?.let { getAll ->
                val allRecipes = getAll()
                _recipes.value = allRecipes
            }
        }
    }
}

//@Suppress("UNCHECKED_CAST")
//class CookbookViewModelFactory(private val repository: RecipeRepository) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return CookbookViewModel(repository) as T
//    }
//}