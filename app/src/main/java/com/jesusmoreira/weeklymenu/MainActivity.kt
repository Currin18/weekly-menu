package com.jesusmoreira.weeklymenu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.jesusmoreira.weeklymenu.data.local.datasource.RecipesLocalDataSource
import com.jesusmoreira.weeklymenu.data.local.db.WeeklyMenuDB
import com.jesusmoreira.weeklymenu.data.repository.RecipeRepository
import com.jesusmoreira.weeklymenu.domain.usecase.recipe.*
import com.jesusmoreira.weeklymenu.ui.App
import com.jesusmoreira.weeklymenu.ui.cookbook.CookbookViewModel
import com.jesusmoreira.weeklymenu.ui.menu.MenuViewModel
import com.jesusmoreira.weeklymenu.ui.recipeform.RecipeFormViewModel
import com.jesusmoreira.weeklymenu.ui.recipedetail.RecipeDetailViewModel
import com.jesusmoreira.weeklymenu.ui.theme.WeeklyMenuTheme

class MainActivity : ComponentActivity() {

    private lateinit var db: WeeklyMenuDB

    private lateinit var recipeRepository: RecipeRepository

    private lateinit var cookbookViewModel: CookbookViewModel
    private lateinit var recipeFormViewModel: RecipeFormViewModel
    private lateinit var recipeDetailViewModel: RecipeDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = WeeklyMenuDB.getInstance(this)

        recipeRepository = RecipeRepository(RecipesLocalDataSource(db.recipeDao()))

        val menuViewModel = MenuViewModel() // TODO: manage with repository
        cookbookViewModel = CookbookViewModel(
            getAllRecipes = GetAllRecipesUseCase(recipeRepository),
            insertRecipe = InsertRecipeUseCase(recipeRepository),
        )
        recipeFormViewModel = RecipeFormViewModel(
            getRecipeById = GetRecipeByIdUseCase(recipeRepository),
            insertRecipe = InsertRecipeUseCase(recipeRepository),
            updateRecipe = UpdateRecipeUseCase(recipeRepository),
        )
        recipeDetailViewModel = RecipeDetailViewModel(
            getRecipeById = GetRecipeByIdUseCase(recipeRepository),
            deleteRecipe = DeleteRecipeUseCase(recipeRepository),
        )

        setContent {
            WeeklyMenuTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    App(
                        menuViewModel = menuViewModel,
                        cookbookViewModel = cookbookViewModel,
                        recipeFormViewModel = recipeFormViewModel,
                        recipeDetailViewModel = recipeDetailViewModel,
                    )
                }
            }
        }
    }
}