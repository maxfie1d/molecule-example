package com.github.maxfie1d.compose.moleculetest

sealed class ViewState {
    object Loading : ViewState()

    data class Data(
        val season: String,
        val food: String,
        val color: String
    ) : ViewState()
}
