package com.jesusmoreira.weeklymenu.domain.usecase.recipe

import com.jesusmoreira.weeklymenu.data.repository.RecipeRepository
import com.jesusmoreira.weeklymenu.domain.mapper.toDBRecipe
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.jesusmoreira.weeklymenu.domain.model.Recipe as DomainRecipe

class UpdateRecipeUseCase (
    private val recipeRepository: RecipeRepository,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
) {
    suspend operator fun invoke(recipe: DomainRecipe) =
        withContext(defaultDispatcher) {
            recipeRepository.update(recipe.toDBRecipe())
        }
}