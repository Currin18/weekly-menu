package com.jesusmoreira.weeklymenu.ui.recipedetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jesusmoreira.weeklymenu.domain.model.Difficulty
import com.jesusmoreira.weeklymenu.domain.model.Service
import com.jesusmoreira.weeklymenu.ui.common.DefaultImage
import com.jesusmoreira.weeklymenu.ui.common.DifficultyWidget
import com.jesusmoreira.weeklymenu.ui.common.TimeWidget

@Composable
fun RecipeOverview(
    name: String,
    description: String,
    time: Int,
    difficulty: Difficulty,
    services: Set<Service>,
    tags: Set<String>,
) {
    val horizontalPadding = 16.dp
    val verticalPadding = 8.dp

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box {
            DefaultImage(aspectRatio = 2f / 1)
            ServiceList(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 16.dp),
                services = services
            )
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = horizontalPadding, vertical = verticalPadding),
            style = MaterialTheme.typography.titleLarge,
            text = name
        )
        RecipeOverviewExtra(
            modifier = Modifier.padding(horizontal = horizontalPadding, vertical = verticalPadding),
            time = time,
            difficulty = difficulty
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = horizontalPadding, vertical = verticalPadding),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Justify,
            text = description
        )
        TagList(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = horizontalPadding, vertical = verticalPadding),
            tags = tags
        )
    }
}

@Composable
fun ServiceList(modifier: Modifier = Modifier, services: Set<Service> = setOf()) {
    if (services.isNotEmpty()) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.End
        ) {
            services.forEach {
                Text(
                    modifier = Modifier
                        .clip(RoundedCornerShape(topStart = 4.dp, bottomStart = 4.dp))
                        .background(MaterialTheme.colorScheme.tertiaryContainer)
                        .padding(8.dp),
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                    style = MaterialTheme.typography.bodyLarge,
                    text = it.toString().capitalize(Locale.current)
                )
            }
        }
    }
}

@Composable
fun RecipeOverviewExtra(modifier: Modifier = Modifier, time: Int, difficulty: Difficulty) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        TimeWidget(time = time)
        DifficultyWidget(difficulty = difficulty)
    }
}

@Composable
fun TagList(
    modifier: Modifier = Modifier,
    tags: Set<String> = setOf(),
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        tags.forEach {
            Text(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(MaterialTheme.colorScheme.secondaryContainer)
                    .padding(4.dp),
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                style = MaterialTheme.typography.bodySmall,
                text = it
            )
        }
    }
}

/**
 * Previews
 */

@Composable
@Preview(showBackground = true)
fun RecipeOverviewPreview() {
    RecipeOverview(
        name = "Spicy Hoisin Pork",
        description = "Whip out your wok and get sticky pork, crisp greens and fluffy " +
                "rice on the table in no time! To serve garnish with a sprinkle of fresh " +
                "chilli. Simple, spicy and full of garlicky goodness!",
        time = 35,
        difficulty = Difficulty.MEDIUM,
        services = setOf(Service.LUNCH, Service.DINNER),
        tags = setOf("Asian", "Pork", "Rice", "Spicy")
    )
}