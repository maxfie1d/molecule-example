package com.github.maxfie1d.compose.moleculetest

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import kotlinx.coroutines.flow.Flow

@Composable
fun buildViewState(
    seasonFlow: Flow<String>,
    foodFlow: Flow<String>,
    colorFlow: Flow<String>
): ViewState {
    val season by seasonFlow.collectAsState(null)
    val food by foodFlow.collectAsState(null)
    val color by colorFlow.collectAsState(null)

    return if (season == null && food == null && color == null) {
        ViewState.Loading
    } else {
        ViewState.Data(
            season = season ?: "N/A",
            food = food ?: "N/A",
            color = color ?: "N/A"
        )
    }
}
