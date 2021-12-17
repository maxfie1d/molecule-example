package com.github.maxfie1d.compose.moleculetest

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun MainScreen(state: ViewState) {
    when (state) {
        ViewState.Loading -> {
            Text(text = "Loading...")
        }
        is ViewState.Data -> {
            Column {
                Text(text = "季節: " + state.season)
                Text(text = "食べ物: " + state.food)
                Text(text = "色: " + state.color)
            }
        }
    }
}
