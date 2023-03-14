package com.jesusmoreira.weeklymenu.ui.common.form

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

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
        onValueChange = { onValueChange(it.toIntOrNull() ?: 0) },
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.None,
            keyboardType = KeyboardType.Number,
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputChip(
    modifier: Modifier = Modifier,
    label: String = "",
    items: List<String> = emptyList(),
    onAddItem: (String) -> Unit = {},
    onRemoveItem: (String) -> Unit = {},
) {
    var newTag by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant,
                shape = TextFieldDefaults.filledShape
            ),
    ) {
        ChipGroup(items = items, onClick = { onRemoveItem(it) })
        InputText(
            label = label,
            value = newTag,
            onValueChange = {
                newTag = when {
                    it.contains("\n") -> {
                        onAddItem(newTag)
                        ""
                    }
                    else -> it
                }
            }
        )
    }
}

/**
 * Previews
 */

@Composable
@Preview(group = "InputText", name = "Empty")
fun InputTextEmpty() {
    InputText(label = "Name", value = "")
}

@Composable
@Preview(group = "InputText", name = "Default")
fun InputTextDefault() {
    InputText(label = "Name", value = "John")
}

@Composable
@Preview(group = "InputNumber", name = "Empty")
fun InputNumberEmpty() {
    InputNumber(label = "Age", value = 0)
}

@Composable
@Preview(group = "InputNumber", name = "Default")
fun InputNumberDefault() {
    InputNumber(label = "Age", value = 33)
}

@Composable
@Preview(group = "InputChip", name = "Default")
fun InputChipDefault() {
    InputChip(label = "Tags", items = List(5) { "Item $it" })
}

@Composable
@Preview(group = "InputChip", name = "Empty")
fun InputChipEmpty() {
    InputChip(label = "Tags")
}
