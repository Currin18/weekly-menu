package com.jesusmoreira.weeklymenu.ui.recipeform

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jesusmoreira.weeklymenu.domain.model.Difficulty
import com.jesusmoreira.weeklymenu.ui.common.DropDown
import com.jesusmoreira.weeklymenu.ui.common.InputNumber
import com.jesusmoreira.weeklymenu.ui.common.InputText
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
    val time: Int by viewModel.time
        .observeAsState(initial = 0)
    val difficulty: Difficulty by viewModel.difficulty
        .observeAsState(initial = Difficulty.EASY)

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
                    description, { viewModel.setDescription(it) },
                    time, { viewModel.setTime(it) },
                    difficulty, { viewModel.setDifficulty(it) }
                ) {
                    viewModel.onSubmit()
                    navController.popBackStack()
                }
            }
        }
    )
}

@Composable
fun RecipeForm(
    name: String = "",
    onChangeName: (String) -> Unit = {},
    description: String = "",
    onChangeDescription: (String) -> Unit = {},
    time: Int = 0,
    onChangeTime: (Int) -> Unit = {},
    difficulty: Difficulty = Difficulty.EASY,
    onChangeDifficulty: (Difficulty) -> Unit = {},
    onSubmit: () -> Unit,
) {
    val difficulties = Difficulty.values()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        contentPadding = PaddingValues(16.dp)

    ) {

        item {
            InputText(label = "Name", value = name) { onChangeName(it) }
        }

        item { InputText(label = "Description", value = description) { onChangeDescription(it) } }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                InputNumber(
                    modifier = Modifier.weight(1f),
                    label = "Time",
                    value = time
                ) { onChangeTime(it) }
                DropDown(
                    modifier = Modifier.weight(1f),
                    label = "Difficult",
                    value = difficulty.name,
                    items = difficulties.map { it.name }
                ) { onChangeDifficulty(difficulties[it]) }
            }
        }

        item {
            Button(onClick = { onSubmit() }) {
                Text(text = "Submit")
            }
        }
    }
}


/**
 * Preview
 */


@Composable
@Preview(showBackground = true)
fun RecipeScreenPreview() {
    RecipeFormScreen(rememberNavController(), RecipeFormViewModel())
}