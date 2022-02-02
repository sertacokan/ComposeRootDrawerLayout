package com.example.rootdrawerlayout

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class RootDrawerContentProperties(
    val minContentCornerRadius: Dp = 0.dp,
    val maxContentCornerRadius: Dp = 8.dp,
    val minContentElevation: Dp = 0.dp,
    val maxContentElevation: Dp = 4.dp,
)
