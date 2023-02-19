package com.jesusmoreira.weeklymenu.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalDining
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jesusmoreira.weeklymenu.domain.model.Recipe
import com.jesusmoreira.weeklymenu.domain.model.Service

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeCard(recipe: Recipe, onClick: (Recipe) -> Unit = {}) {
    var isFavorite by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp),
        onClick = { onClick(recipe) }
    ) {
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
                RecipeCardContent(recipe.name, recipe.services, recipe.time)
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
fun RecipeCardImage(description: String = "") {
    DefaultImage()
}

@Composable
fun DefaultImage(
    description: String = "Default image",
    padding: Dp = 32.dp,
    aspectRatio: Float = 1f
) {
    Box(
        modifier = Modifier
            .aspectRatio(aspectRatio, aspectRatio == 1f)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .padding(padding)
    ) {
        Icon(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            imageVector = Icons.Filled.LocalDining,
            contentDescription = description,
            tint = MaterialTheme.colorScheme.onSecondaryContainer
        )
    }
}

@Composable
fun TimeWidget(
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.bodySmall,
    time: Int
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(2.dp),
    ) {
        Icon(imageVector = Icons.Outlined.Timer, contentDescription = "Timer icon")
        Text(
            text = when {
                time > 60 -> "${time / 60}h ${time % 60}min"
                else -> "${time}min"
            },
            style = textStyle
        )
    }
}

@Composable
fun RecipeCardContent(name: String, services: Set<Service>, time: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = services.sorted().joinToString(" · "),
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
        TimeWidget(
            modifier = Modifier.height(16.dp),
            time = time
        )
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
@Preview
fun RecipeCardPreview() {
    RecipeCard(Recipe(
        id = 1,
        name ="Butter Chicken Curry",
        services = setOf(Service.DINNER),
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
        services = setOf(Service.DINNER),
        time = 35
    )
}

@Composable
@Preview(showBackground = true, heightDp = 96)
fun RecipeCardContentPreviewStrange() {
    RecipeCardContent(
        name = "Cheese and Tarragon Mushrooms with tomato",
        services = setOf(Service.LUNCH, Service.DINNER),
        time = 324
    )
}

@Composable
@Preview(showBackground = true, heightDp = 96)
fun RecipeCardContentPreviewEmpty() {
    RecipeCardContent(
        name = "Cheese and Tarragon Mushrooms with tomato",
        services = setOf(),
        time = 0
    )
}