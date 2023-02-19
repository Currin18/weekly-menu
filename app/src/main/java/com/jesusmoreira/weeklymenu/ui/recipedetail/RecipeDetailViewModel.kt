package com.jesusmoreira.weeklymenu.ui.recipedetail

import androidx.lifecycle.*
import com.jesusmoreira.weeklymenu.domain.usecase.recipe.GetRecipeByIdUseCase
import kotlinx.coroutines.Dispatchers


class RecipeDetailViewModel(
    private val getRecipeById: GetRecipeByIdUseCase? = null,
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
}