package com.jesusmoreira.weeklymenu.ui.menu.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.time.LocalDate

@Composable
fun DailyMenu(selectedDate: LocalDate) {
    Column(
        modifier = Modifier.background(MaterialTheme.colorScheme.surface),
    ) {
        DateRow(selectedDate = selectedDate)
        Divider()
        ServiceRow()
    }
}

@Composable
@Preview(showBackground = true)
fun DailyMenuPreview() {
    DailyMenu(LocalDate.now())
}

@Composable
fun DateRow(selectedDate: LocalDate) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(32.dp),
//            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier.size(32.dp),
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "${selectedDate.dayOfMonth}"
            )
        }
        Divider(
//            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
        )
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)) {
            Text(text = "${selectedDate.month} ${selectedDate.year}")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DateRowPreview() {
    DateRow(selectedDate = LocalDate.now())
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ServiceRow() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        val grouped: MutableMap<String, List<String>> = mutableMapOf()
        grouped["Almuerzo"] = listOf(
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
        )
        grouped["Cena"] = listOf(
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas ${Math.random()}",
            "Huevos con patatas fritas Last",
        )
        grouped.forEach { (service, recipes) ->
            stickyHeader {
                Divider()
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min)
                        .background(MaterialTheme.colorScheme.surface),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Box(
                        modifier = Modifier.size(32.dp),
                    )
                    Divider(
//            color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(1.dp)
                    )
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            text = service
                        )
                        Divider()
                    }
                }
            }

            items(
                items = recipes,
                key = { collection -> collection}
            ) { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Box(
                        modifier = Modifier.size(32.dp),
                    )
                    Divider(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(1.dp)
                    )
                    Column(
                    ) {
                        Divider()
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            text = item
                        )
                    }
                }
            }

            item {

            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ServiceRowPreview() {
    ServiceRow()
}