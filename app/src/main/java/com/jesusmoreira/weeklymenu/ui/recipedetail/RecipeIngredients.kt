package com.jesusmoreira.weeklymenu.ui.recipedetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jesusmoreira.weeklymenu.R
import com.jesusmoreira.weeklymenu.domain.model.Ingredient
import com.jesusmoreira.weeklymenu.domain.model.Unit

@Composable
fun RecipeIngredients(ingredients: List<Ingredient> = listOf()) {
    val horizontalPadding = 16.dp
    val verticalPadding = 16.dp

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = horizontalPadding, vertical = verticalPadding),
            style = MaterialTheme.typography.titleMedium,
            text = stringResource(id = R.string.ingredients)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = horizontalPadding, vertical = verticalPadding),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ingredients.forEach {
                val plural = "${it.amount}" != "1"

                Text(
                    style = MaterialTheme.typography.bodyLarge,
                    text = "${it.name}: ${it.amount} ${unitName(unit = it.unit, plural = plural)}"
                )
            }
        }
    }
}

@Composable
fun unitName(unit: Unit, plural: Boolean = false): String {
    if (plural) {
        return when (unit) {
            Unit.UNITS -> stringResource(id = R.string.unit_unit_plural)
            Unit.GRAMS -> stringResource(id = R.string.unit_gram_plural)
            Unit.KILOGRAMS -> stringResource(id = R.string.unit_kilogram_plural)
            Unit.MILLILITRE -> stringResource(id = R.string.unit_millilitre_plural)
            Unit.LITRE -> stringResource(id = R.string.unit_litre_plural)
        }.toLowerCase(Locale.current)
    }

    return when(unit) {
        Unit.UNITS -> stringResource(id = R.string.unit_unit)
        Unit.GRAMS -> stringResource(id = R.string.unit_gram)
        Unit.KILOGRAMS -> stringResource(id = R.string.unit_kilogram)
        Unit.MILLILITRE -> stringResource(id = R.string.unit_millilitre)
        Unit.LITRE -> stringResource(id = R.string.unit_litre)
    }.toLowerCase(Locale.current)
}

/**
 * Previews
 */

@Composable
@Preview
fun RecipeIngredientsPreview() {
    RecipeIngredients(listOf(
        Ingredient("Potato", 1, Unit.UNITS),
        Ingredient("Sugar", 5.5f, Unit.GRAMS),
    ))
}