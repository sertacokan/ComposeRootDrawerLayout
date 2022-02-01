package com.example.rootdrawerlayout

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.setValue

class RootDrawerLayoutState(initial: RootDrawerLayoutValue = RootDrawerLayoutValue.Closed) {
    var rootDrawerLayoutValue by mutableStateOf(initial)
        private set

    fun toggle() {
        rootDrawerLayoutValue = !rootDrawerLayoutValue
    }

    companion object {
        val RootDrawerSaver: Saver<RootDrawerLayoutState, *> = Saver(
            save = { it.rootDrawerLayoutValue },
            restore = { initial ->
                RootDrawerLayoutState(initial)
            }
        )
    }
}
