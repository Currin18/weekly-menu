package com.jesusmoreira.weeklymenu.ui.common

import android.util.Log
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.burnoutcrew.reorderable.*
import kotlin.math.roundToInt

data class Position(var from: Float = -1f, var to: Float = -1f)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DraggableList() {
    val items = remember { mutableStateOf(List(5) { "Item $it" }) }
    val state = rememberReorderableLazyListState(onMove = { from, to ->
        items.value = items.value.toMutableList().apply {
            add(to.index, removeAt(from.index))
        }
    })
    val position = remember{ mutableStateOf(Position()) }

    LaunchedEffect(position) {
        Log.d("DRAGGABLE_LIST", "from: ${position.value.from}, to: ${position.value.to}")
    }

    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        items.value.forEach { item ->
//            var offsetY by remember { mutableStateOf(0f) }
            val offsetY  =  remember { Animatable(0f) }

            Text(
                text = item,
                modifier = Modifier
                    .fillMaxWidth()
                    .offset { IntOffset(0, offsetY.value.roundToInt()) }
                    .draggable(
                        state = rememberDraggableState { delta ->
                            coroutineScope.launch {
                                offsetY.snapTo(offsetY.value + delta)
                                position.value.from = offsetY.value + delta
                            }
                        },
                        orientation = Orientation.Vertical,
                        onDragStarted = {
                            position.value.from = it.y
                            Log.d("DRAGGABLE_LIST", "onDragStarted ${it.y}")
                        },
                        onDragStopped = {
                            coroutineScope.launch {
                                offsetY.animateTo(
                                    targetValue = 0f,
                                    animationSpec = tween(
                                        durationMillis = 3000,
                                        delayMillis = 0
                                    )
                                )
                            }
                        }
                    )
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .padding(8.dp)
            )
        }
    }
}

// @Composable
inline fun <T> LazyListScope.reorderableItems(
    items: List<T>,
    state: ReorderableState<*>,
    noinline key: ((item: T) -> Any)? = null,
    crossinline itemContent: @Composable ColumnScope.(item: T) -> Unit
) {
    items(items) {
        ReorderableItem(reorderableState = state, key = key) { isDragging ->
            val elevation = animateDpAsState(targetValue = if (isDragging) 16.dp else 0.dp)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(elevation = elevation.value)
                    .background(MaterialTheme.colorScheme.surfaceVariant)
            ) {
                itemContent(it)
            }
        }
    }
}

/**
 * Previews
 */

@Composable
@Preview(group = "DraggableList", name = "Default", showBackground = true)
fun DraggableListDefault() {
    /*val items = remember { mutableStateOf(List(5) { "Item $it" }) }
    val state = rememberReorderableLazyListState(onMove = { from, to ->
        items.value = items.value.toMutableList().apply {
            add(to.index, removeAt(from.index))
        }
    })

    LazyColumn {
        reorderableItems(items.value, state) {
            Text(it, modifier = Modifier.padding(8.dp))
        }
    }*/

    DraggableList()
}
