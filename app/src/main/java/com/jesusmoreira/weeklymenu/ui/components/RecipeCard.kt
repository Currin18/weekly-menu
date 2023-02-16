package com.jesusmoreira.weeklymenu.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalDining
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jesusmoreira.weeklymenu.domain.model.Recipe
import com.jesusmoreira.weeklymenu.domain.model.Service

@Composable
fun RecipeCard(recipe: Recipe) {
    var isFavorite by remember { mutableStateOf(false) }
    Surface(modifier = Modifier.shadow(4.dp).padding(4.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(96.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                RecipeCardImage()
                RecipeCardContent(recipe.name, recipe.categories, recipe.time)
            }
            RecipeCardFavorite(
                isFavorite = isFavorite,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(4.dp),
            ) { isFavorite = !isFavorite }
        }
    }
}

@Composable
fun RecipeCardImage(description: String = "Default image") {
    Box(
        modifier = Modifier
            .aspectRatio(1f, true)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Icon(
            modifier = Modifier
                .size(32.dp)
                .align(Alignment.Center),
            imageVector = Icons.Filled.LocalDining,
            contentDescription = description,
            tint = MaterialTheme.colorScheme.onSecondaryContainer
        )
    }
}

@Composable
fun TimeWidget(time: Int) {
    Row(
        modifier = Modifier.height(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(2.dp),
    ) {
        Icon(imageVector = Icons.Outlined.Timer, contentDescription = "Timer icon")
        Text(
            text = when {
                time > 60 -> "${time / 60}h ${time % 60}min"
                else -> "${time}min"
            },
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
fun RecipeCardContent(name: String, category: Set<Service>, time: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = category.sorted().joinToString(" · "),
            maxLines = 1,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.labelMedium
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = name,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.headlineSmall,
            fontSize = 16.sp
        )
        TimeWidget(time)
    }
}

@Composable
fun RecipeCardFavorite(
    isFavorite: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    if (isFavorite) {
        Icon(
            modifier = modifier.clickable { onClick() },
            imageVector = Icons.Default.Star,
            contentDescription = "Is favorite",
            tint = MaterialTheme.colorScheme.primary
        )
    } else {
        Icon(
            modifier = modifier.clickable { onClick() },
            imageVector = Icons.Default.StarOutline,
            contentDescription = "Is not favorite",
            tint = MaterialTheme.colorScheme.primary
        )
    }
}

/**
 * Previews
 */

@Composable
@Preview(showBackground = true)
fun RecipeCardPreview() {
    RecipeCard(Recipe(
        id = 1,
        name ="Butter Chicken Curry",
        categories = setOf(Service.DINNER),
        time = 35
    ))
}

@Composable
@Preview(heightDp = 96)
fun RecipeImageCardPreviewDefault() {
    RecipeCardImage()
}

@Composable
@Preview(showBackground = true, heightDp = 96)
fun RecipeCardContentPreviewDefault() {
    RecipeCardContent(
        name = "Butter Chicken Curry",
        category = setOf(Service.DINNER),
        time = 35
    )
}

@Composable
@Preview(showBackground = true, heightDp = 96)
fun RecipeCardContentPreviewStrange() {
    RecipeCardContent(
        name = "Cheese and Tarragon Mushrooms with tomato",
        category = setOf(Service.LUNCH, Service.DINNER),
        time = 324
    )
}

@Composable
@Preview(showBackground = true, heightDp = 96)
fun RecipeCardContentPreviewEmpty() {
    RecipeCardContent(
        name = "Cheese and Tarragon Mushrooms with tomato",
        category = setOf(),
        time = 0
    )
}