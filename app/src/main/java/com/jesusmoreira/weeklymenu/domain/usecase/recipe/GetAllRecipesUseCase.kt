package com.jesusmoreira.weeklymenu.domain.usecase.recipe

import com.jesusmoreira.weeklymenu.data.repository.RecipeRepository
import com.jesusmoreira.weeklymenu.domain.mapper.toDomainRecipe
import com.jesusmoreira.weeklymenu.domain.model.Recipe as DomainRecipe
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetAllRecipesUseCase (
    private val recipeRepository: RecipeRepository,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
) {
    suspend operator fun invoke(): List<DomainRecipe> =
        withContext(defaultDispatcher) {
            val recipes = recipeRepository.getAll()
            val result: List<DomainRecipe> = recipes.map { it.toDomainRecipe() }
            result
        }

//    private suspend fun FlowCollector<List<Recipe>>.execute() {
//        val recipes = repository.getRecipeList()
//        emit(recipes)
//    }
//
//    suspend operator fun invoke() = flow {
//        execute()
//    }.flowOn(Dispatchers.IO)
}