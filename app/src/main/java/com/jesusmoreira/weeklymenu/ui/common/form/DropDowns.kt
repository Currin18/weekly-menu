package com.jesusmoreira.weeklymenu.ui.common.form

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DropDown(
    modifier: Modifier = Modifier,
    label: String = "Label",
    value: String = "",
    items: List<String> = listOf(),
    onSelectedOption: (Int) -> Unit = {},
) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.TopStart)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { expanded = true })
                .background(MaterialTheme.colorScheme.surfaceVariant)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(
                text = label,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = value,
                modifier = Modifier.fillMaxWidth()
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            items.forEachIndexed { index, item ->
                DropdownMenuItem(
                    text = { Text(text = item.capitalize(Locale.current)) },
                    onClick = {
                        onSelectedOption(index)
                        expanded = false
                    }
                )
            }
        }
    }
}

/**
 * Previews
 */
