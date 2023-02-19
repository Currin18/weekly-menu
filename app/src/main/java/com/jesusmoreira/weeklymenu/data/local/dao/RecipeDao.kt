package com.jesusmoreira.weeklymenu.data.local.dao

import androidx.room.*
import com.jesusmoreira.weeklymenu.data.local.entity.Recipe

@Dao
interface RecipeDao {
    @Query("SELECT * FROM recipe")
    fun getAll(): List<Recipe>

    @Query("SELECT * FROM recipe WHERE id = :recipeId")
    fun getById(recipeId: Int): Recipe

//    @Query("SELECT * FROM recipe WHERE id IN (:recipeIds)")
//    fun loadAllByIds(recipeIds: IntArray): List<Recipe>

//    @Query("SELECT * FROM recipe WHERE name LIKE '%:filer%'")
//    fun filterByName(filter: String): List<Recipe>

    @Insert
    fun insert(recipe: Recipe)

    @Update
    fun update(recipe: Recipe)

//    @Insert
//    fun insertAll(vararg recipes: Recipe)

    @Delete
    fun delete(recipe: Recipe)
}