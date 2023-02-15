package com.jesusmoreira.weeklymenu.domain.usecase.recipe

import com.jesusmoreira.weeklymenu.data.repository.RecipeRepository
import com.jesusmoreira.weeklymenu.domain.mapper.toDBRecipe
import com.jesusmoreira.weeklymenu.domain.model.Recipe
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class InsertRecipeUseCase(
    private val recipeRepository: RecipeRepository,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
) {
    suspend operator fun invoke(recipe: Recipe) {
        withContext(defaultDispatcher) {
            recipeRepository.insert(recipe.toDBRecipe())
        }
    }
}