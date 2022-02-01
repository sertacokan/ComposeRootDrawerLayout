package com.example.rootdrawerlayout

enum class RootDrawerLayoutValue {
    Closed, Expanded;

    val isExpanded: Boolean get() = this == Expanded

    val isClosed: Boolean get() = this == Closed

    operator fun not(): RootDrawerLayoutValue {
        return when (this) {
            Closed -> Expanded
            Expanded -> Closed
        }
    }
}
