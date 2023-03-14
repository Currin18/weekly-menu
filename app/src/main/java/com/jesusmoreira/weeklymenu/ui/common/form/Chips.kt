package com.jesusmoreira.weeklymenu.ui.common.form

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun TrailingIcon(onClick: () -> Unit){
    IconButton(
        onClick = { onClick() },
        modifier = Modifier.padding(0.dp).size(16.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "Chip trailing icon",
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Chip(
    value: String,
    isRemovable: Boolean = false,
    onClick: (String) -> Unit = {},
) {
    InputChip(
        modifier = Modifier.wrapContentWidth(),
        selected = true,
        onClick = {},
        label = { Text(text = value, maxLines = 1) },
        trailingIcon = {
            if (isRemovable) { TrailingIcon(onClick = { onClick(value) }) }
        }
    )
}

@Composable
fun ChipGroup(
    items: List<String>,
    isRemovable: Boolean = false,
    onClick: (String) -> Unit = {}
) {
    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        mainAxisSpacing = 4.dp
    ) {
        items.forEach {
            Chip(
                value = it,
                isRemovable = isRemovable,
                onClick = onClick
            )
        }
    }
}

/**
 * Previews
 */

@Composable
@Preview(showBackground = true, widthDp = 250)
fun ChipDefault() {
    Chip(value = "chicken")
}

@Composable
@Preview(showBackground = true, widthDp = 250)
fun ChipRemovable() {
    Chip(value = "chicken", isRemovable = true)
}

@Composable
@Preview(showBackground = true)
fun ChipGroupDefault() {
    ChipGroup(
        items = List(5) { "Item $it" },
    )
}

@Composable
@Preview(showBackground = true)
fun ChipGroupRemovable() {
    ChipGroup(
        items = List(5) { "Item $it" },
        isRemovable = true
    )
}