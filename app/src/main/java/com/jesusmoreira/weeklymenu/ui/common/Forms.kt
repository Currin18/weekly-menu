package com.jesusmoreira.weeklymenu.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputText(
    modifier: Modifier = Modifier,
    label: String = "",
    value: String = "",
    capitalization: KeyboardCapitalization = KeyboardCapitalization.Sentences,
    onValueChange: (String) -> Unit = {}
) {
    TextField(
        modifier = modifier.fillMaxWidth(),
        label = { Text(text = label) },
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(capitalization = capitalization)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputNumber(
    modifier: Modifier = Modifier,
    label: String = "",
    value: Int = 0,
    onValueChange: (Int) -> Unit = {}
) {
    TextField(
        modifier = modifier.fillMaxWidth(),
        label = { Text(text = label) },
        value = "$value",
        onValueChange = { onValueChange(it.toInt()) },
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.None,
            keyboardType = KeyboardType.Number,
        )
    )
}

@Composable
fun DropDown(
    modifier: Modifier = Modifier,
    label: String = "Label",
    value: String = "",
    items: List<String> = listOf(),
    onSelectedOption: (Int) -> Unit = {},
) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = modifier.fillMaxSize().wrapContentSize(Alignment.TopStart)) {
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