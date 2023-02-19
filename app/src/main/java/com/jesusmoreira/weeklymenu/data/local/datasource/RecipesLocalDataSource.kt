package com.jesusmoreira.weeklymenu.data.local.datasource

import com.jesusmoreira.weeklymenu.data.local.dao.RecipeDao
import com.jesusmoreira.weeklymenu.data.local.entity.Recipe

class RecipesLocalDataSource(private val recipeDao: RecipeDao) {
    fun getAll(): List<Recipe> = recipeDao.getAll()
    fun getById(recipeId: Int): Recipe = recipeDao.getById(recipeId)
    fun insert(recipe: Recipe) = recipeDao.insert(recipe)
    fun update(recipe: Recipe) = recipeDao.update(recipe)
    fun delete(recipe: Recipe) = recipeDao.delete(recipe)
}