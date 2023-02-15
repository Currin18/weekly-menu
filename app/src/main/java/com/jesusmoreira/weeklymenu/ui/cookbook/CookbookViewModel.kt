package com.jesusmoreira.weeklymenu.ui.cookbook

import androidx.lifecycle.*
import com.jesusmoreira.weeklymenu.domain.model.Recipe
import com.jesusmoreira.weeklymenu.domain.usecase.recipe.GetAllRecipesUseCase
import kotlinx.coroutines.launch

class CookbookViewModel(private val getAllRecipes: GetAllRecipesUseCase?): ViewModel() {
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading
    fun startLoading() = run { _isLoading.value = true }
    fun stopLoading() = run { _isLoading.value = false }

    // private val _recipes = MutableLiveData<List<Recipe>>()
    private val _recipes by lazy {
        MutableLiveData<List<Recipe>>()
    }
    val recipes: LiveData<List<Recipe>> get() = _recipes

    init {
        loadRecipes()
    }

    fun loadRecipes() {
//        startLoading()
        viewModelScope.launch {
            getAllRecipes?.let { getAll ->
                _recipes.value = getAll()
//                stopLoading()
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