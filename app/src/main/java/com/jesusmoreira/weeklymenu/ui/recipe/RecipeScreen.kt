package com.jesusmoreira.weeklymenu.ui.recipe

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jesusmoreira.weeklymenu.ui.components.TopActionBar
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeScreen(navController: NavController, viewModel: RecipeViewModel) {
    val coroutineScope = rememberCoroutineScope()
    val name: String by viewModel.name
        .observeAsState(initial = "")
    val description: String by viewModel.description
        .observeAsState(initial = "")

    Scaffold(
        topBar = { TopActionBar(
            title = "New recipe",
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
                    coroutineScope.launch {
                        viewModel.onSubmit()
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
    RecipeScreen(rememberNavController(), RecipeViewModel())
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
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
        Text(text = "Name")
        TextField(
            value = name,
            onValueChange = { onChangeName(it) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(8.dp))

        Text(text = "Description")
        TextField(
            value = description,
            onValueChange = { onChangeDescription(it) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(8.dp))

        Button(onClick = { onSubmit() }) {
            Text(text = "Submit")
        }
    }
}