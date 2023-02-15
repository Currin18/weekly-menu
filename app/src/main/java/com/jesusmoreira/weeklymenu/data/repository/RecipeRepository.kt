package com.jesusmoreira.weeklymenu.data.repository

import com.jesusmoreira.weeklymenu.data.local.datasource.RecipesLocalDataSource
import com.jesusmoreira.weeklymenu.data.local.entity.Recipe as LocalRecipe

class RecipeRepository(
    private val recipesLocalDataSource: RecipesLocalDataSource
) {
    fun getAll() = recipesLocalDataSource.getAll()
    fun findById(recipeId: Int) = recipesLocalDataSource.findById(recipeId)

    fun insert(recipe: LocalRecipe) = recipesLocalDataSource.insert(recipe)

    fun delete(recipe: LocalRecipe) = recipesLocalDataSource.delete(recipe)

//    suspend fun getRecipeListByIds(vararg ids: Int) = dao.loadAllByIds(ids)
//    suspend fun filterRecipeListByName(filter: String) = dao.filterByName(filter)
//    suspend fun insertRecipe(recipe: RecipeEntity) = dao.insert(recipe)
//    suspend fun insertRecipes(vararg recipes: RecipeEntity) = dao.insertAll(*recipes)
//    suspend fun deleteRecipe(recipe: RecipeEntity) = dao.delete(recipe)
}