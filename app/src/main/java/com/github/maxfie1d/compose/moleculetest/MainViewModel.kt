package com.github.maxfie1d.compose.moleculetest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.cash.molecule.AndroidUiDispatcher
import app.cash.molecule.launchMolecule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow

class MainViewModel : ViewModel() {
    private val moleculeScope =
        CoroutineScope(viewModelScope.coroutineContext + AndroidUiDispatcher.Main)

    val state: StateFlow<ViewState> = moleculeScope.launchMolecule {
        buildViewState(seasonFlow, foodFlow, colorFlow)
    }

    private val seasonFlow: Flow<String> = makeFlow(listOf("春", "夏", "秋", "冬"), 2000)

    private val foodFlow: Flow<String> = makeFlow(listOf("ピザ", "寿司", "ステーキ", "おでん"), 3000)

    private val colorFlow: Flow<String> = makeFlow(listOf("オレンジ", "みどり", "むらさき", "きいろ"), 5000)

    private fun makeFlow(data: List<String>, interval: Long): Flow<String> {
        return flow {
            repeat(1000) {
                delay(interval)
                val index = it % data.size
                emit(data[index])
            }
        }
    }
}
