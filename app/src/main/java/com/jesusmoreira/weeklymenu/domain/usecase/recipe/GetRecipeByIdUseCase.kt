package com.jesusmoreira.weeklymenu.domain.usecase.recipe

import com.jesusmoreira.weeklymenu.data.repository.RecipeRepository
import com.jesusmoreira.weeklymenu.domain.mapper.toDomainRecipe
import com.jesusmoreira.weeklymenu.domain.model.Recipe as DomainRecipe
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetRecipeByIdUseCase (
    private val recipeRepository: RecipeRepository,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
) {
    suspend operator fun invoke(id: Int): DomainRecipe =
        withContext(defaultDispatcher) {
            val recipe = recipeRepository.getById(id)
            recipe.toDomainRecipe()
        }
}