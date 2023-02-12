package com.jesusmoreira.weeklymenu.ui.cookbook

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jesusmoreira.weeklymenu.R
import com.jesusmoreira.weeklymenu.ui.components.BottomNavigationBar
import com.jesusmoreira.weeklymenu.ui.components.TopActionBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CookbookScreen(navController: NavHostController) {
    Scaffold(
        topBar = { TopActionBar(stringResource(id = R.string.cookbook)) },
        content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .background(Color.White),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Cookbook Screen")
                }
            }
        },
        bottomBar = { BottomNavigationBar(navController = navController) }
    )
}

@Composable
@Preview(showBackground = true)
fun CookbookScreenPreview() {
    CookbookScreen(navController = rememberNavController())
}
