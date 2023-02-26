package com.jesusmoreira.weeklymenu.ui.recipedetail

import androidx.lifecycle.*
import com.jesusmoreira.weeklymenu.domain.usecase.recipe.DeleteRecipeUseCase
import com.jesusmoreira.weeklymenu.domain.usecase.recipe.GetRecipeByIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecipeDetailViewModel(
    private val getRecipeById: GetRecipeByIdUseCase? = null,
    private val deleteRecipe: DeleteRecipeUseCase? = null,
): ViewModel() {

    private val _recipeId = MutableLiveData<Int>()
    private val recipeId: LiveData<Int> = _recipeId

    fun setRecipeId(recipeId: Int) = run { _recipeId.value = recipeId }

    val recipe = recipeId.switchMap { id ->
        liveData(context = viewModelScope.coroutineContext + Dispatchers.IO) {
            getRecipeById?.let { run ->
                val result = run(id)
                emit(result)
            }
        }
    }

    fun deleteRecipe() {
        viewModelScope.launch {
            deleteRecipe?.let { delete ->
                recipe.value?.let { delete(it) }
            }
        }
    }
}