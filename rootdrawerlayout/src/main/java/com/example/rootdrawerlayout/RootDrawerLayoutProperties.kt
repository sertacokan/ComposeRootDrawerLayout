package com.example.rootdrawerlayout

import androidx.annotation.FloatRange

data class RootDrawerLayoutProperties(
    @FloatRange(from = 0.0, to = 1.0) val drawerMinScale: Float = 0f,
    @FloatRange(from = 0.0, to = 1.0) val drawerMaxScale: Float = 1f,
    @FloatRange(from = 0.0, to = 1.0) val contentMinScale: Float = 0.75f,
    @FloatRange(from = 0.0, to = 1.0) val contentMaxScale: Float = 1f
)
