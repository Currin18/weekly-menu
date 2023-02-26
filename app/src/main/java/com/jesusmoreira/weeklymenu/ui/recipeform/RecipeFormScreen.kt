package com.jesusmoreira.weeklymenu.ui.recipeform

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jesusmoreira.weeklymenu.ui.common.TopActionBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeFormScreen(
    navController: NavController,
    viewModel: RecipeFormViewModel
) {
    val title: String by viewModel.title
        .observeAsState(initial = "")
    val name: String by viewModel.name
        .observeAsState(initial = "")
    val description: String by viewModel.description
        .observeAsState(initial = "")

    Scaffold(
        topBar = { TopActionBar(
            title = title,
            showBackButton = true,
            onBackButton = { navController.popBackStack() }
        ) },
        content = { padding ->
            Column(modifier = Modifier
                .padding(padding)
                .fillMaxSize()) {
                RecipeForm(
                    name, { viewModel.setName(it) },
                    description, { viewModel.setDescription(it) }
                ) {
                    if(viewModel.onSubmit()) {
                        navController.popBackStack()
                    }
                }
            }
        }
    )
}

@Composable
@Preview(showBackground = true)
fun RecipeScreenPreview() {
    RecipeFormScreen(rememberNavController(), RecipeFormViewModel())
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeForm(
    name: String,
    onChangeName: (String) -> Unit,
    description: String,
    onChangeDescription: (String) -> Unit,
    onSubmit: () -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        contentPadding = PaddingValues(16.dp)

    ) {

        item {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Name") },
                value = name,
                onValueChange = { onChangeName(it) },
                keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences)
            )
        }

        item {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Description") },
                value = description,
                onValueChange = { onChangeDescription(it) },
                keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences)
            )
        }

        item {
            Button(onClick = { onSubmit() }) {
                Text(text = "Submit")
            }
        }
    }
}