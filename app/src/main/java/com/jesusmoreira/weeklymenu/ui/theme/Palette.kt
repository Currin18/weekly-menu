package com.jesusmoreira.weeklymenu.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Palette() {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        item { PaletteColor(name = "primary", color = MaterialTheme.colorScheme.primary) }
        item { PaletteColor(name = "onPrimary", color = MaterialTheme.colorScheme.onPrimary) }
        item { PaletteColor(name = "primaryContainer", color = MaterialTheme.colorScheme.primaryContainer) }
        item { PaletteColor(name = "onPrimaryContainer", color = MaterialTheme.colorScheme.onPrimaryContainer) }
        item { PaletteColor(name = "inversePrimary", color = MaterialTheme.colorScheme.inversePrimary) }
        item { Divider() }
        item { PaletteColor(name = "secondary", color = MaterialTheme.colorScheme.secondary) }
        item { PaletteColor(name = "onSecondary", color = MaterialTheme.colorScheme.onSecondary) }
        item { PaletteColor(name = "secondaryContainer", color = MaterialTheme.colorScheme.secondaryContainer) }
        item { PaletteColor(name = "onSecondaryContainer", color = MaterialTheme.colorScheme.onSecondaryContainer) }
        item { Divider() }
        item { PaletteColor(name = "tertiary", color = MaterialTheme.colorScheme.tertiary) }
        item { PaletteColor(name = "onTertiary", color = MaterialTheme.colorScheme.onTertiary) }
        item { PaletteColor(name = "tertiaryContainer", color = MaterialTheme.colorScheme.tertiaryContainer) }
        item { PaletteColor(name = "onTertiaryContainer", color = MaterialTheme.colorScheme.onTertiaryContainer) }
        item { Divider() }
        item { PaletteColor(name = "background", color = MaterialTheme.colorScheme.background) }
        item { PaletteColor(name = "onBackground", color = MaterialTheme.colorScheme.onBackground) }
        item { Divider() }
        item { PaletteColor(name = "surface", color = MaterialTheme.colorScheme.surface) }
        item { PaletteColor(name = "onSurface", color = MaterialTheme.colorScheme.onSurface) }
        item { PaletteColor(name = "surfaceVariant", color = MaterialTheme.colorScheme.surfaceVariant) }
        item { PaletteColor(name = "onSurfaceVariant", color = MaterialTheme.colorScheme.onSurfaceVariant) }
        item { PaletteColor(name = "inverseSurface", color = MaterialTheme.colorScheme.inverseSurface) }
        item { PaletteColor(name = "inverseOnSurface", color = MaterialTheme.colorScheme.inverseOnSurface) }
        item { PaletteColor(name = "surfaceTint", color = MaterialTheme.colorScheme.surfaceTint) }
        item { Divider() }
        item { PaletteColor(name = "error", color = MaterialTheme.colorScheme.error) }
        item { PaletteColor(name = "onError", color = MaterialTheme.colorScheme.onError) }
        item { PaletteColor(name = "errorContainer", color = MaterialTheme.colorScheme.errorContainer) }
        item { PaletteColor(name = "onErrorContainer", color = MaterialTheme.colorScheme.onErrorContainer) }
        item { Divider() }
        item { PaletteColor(name = "outline", color = MaterialTheme.colorScheme.outline) }
        item { PaletteColor(name = "outlineVariant", color = MaterialTheme.colorScheme.outlineVariant) }
        item { Divider() }
        item { PaletteColor(name = "scrim", color = MaterialTheme.colorScheme.scrim) }
    }
}

@Composable
fun PaletteColor(name: String, color: Color) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier
            .size(32.dp)
            .background(color))
        Text(text = name)
    }
}

@Composable
@Preview(showBackground = true)
fun PalettePreview() {
    Palette()
}