package com.example.rootdrawerlayout

import androidx.annotation.FloatRange
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.rootdrawerlayout.RootDrawerLayoutState.Companion.RootDrawerSaver
import kotlin.math.roundToInt

@Composable
fun RootDrawerLayout(
    modifier: Modifier = Modifier,
    rootDrawerLayoutState: RootDrawerLayoutState = rememberRootDrawerState(),
    @FloatRange(from = 0.0, to = 1.0) drawerMinScale: Float = 0f,
    @FloatRange(from = 0.0, to = 1.0) drawerMaxScale: Float = 1f,
    @FloatRange(from = 0.0, to = 1.0) contentMinScale: Float = 0.75f,
    @FloatRange(from = 0.0, to = 1.0) contentMaxScale: Float = 1f,
    minContentCornerRadius: Dp = 0.dp,
    maxContentCornerRadius: Dp = 8.dp,
    minContentElevation: Dp = 0.dp,
    maxContentElevation: Dp = 4.dp,
    drawerContent: @Composable ColumnScope.() -> Unit,
    content: @Composable () -> Unit
) {

    val expandTransition = updateTransition(targetState = rootDrawerLayoutState.rootDrawerLayoutValue, label = "expand_transition")

    val contentScale by expandTransition.animateFloat(label = "content_scale") { layoutValue -> if (layoutValue.isExpanded) contentMinScale else contentMaxScale }
    val drawerScale by expandTransition.animateFloat(label = "drawer_scale") { layoutValue -> if (layoutValue.isExpanded) drawerMaxScale else drawerMinScale }
    val contentCornerRadius by expandTransition.animateDp(label = "content_corner_radius") { layoutValue -> if (layoutValue.isExpanded) maxContentCornerRadius else minContentCornerRadius }
    val contentElevation by expandTransition.animateDp(label = "content_elevation") { layoutValue -> if (layoutValue.isExpanded) maxContentElevation else minContentElevation }

    Layout(
        modifier = modifier,
        content = {
            Column(
                modifier = Modifier
                    .layoutId("drawer")
                    .fillMaxSize()
                    .graphicsLayer {
                        scaleX = drawerScale
                    },
                content = drawerContent
            )
            Surface(
                modifier = Modifier
                    .layoutId("content")
                    .graphicsLayer {
                        scaleY = contentScale
                    },
                elevation = contentElevation,
                content = content,
                shape = RoundedCornerShape(contentCornerRadius)
            )
        }
    ) { measurables, constraint ->

        val width = constraint.maxWidth
        val height = constraint.maxHeight
        val drawerMaxWidth = width / 2

        val drawerPlaceable = measurables.first { it.layoutId == "drawer" }.measure(constraint.copy(maxWidth = drawerMaxWidth))
        val contentPlaceable = measurables.first { it.layoutId == "content" }.measure(constraint)

        layout(width, height) {
            val drawerWidth = drawerPlaceable.width * drawerScale
            val contentTop = (height - contentPlaceable.height) / 2f

            drawerPlaceable.placeRelative(x = 0, y = 0)
            contentPlaceable.placeRelative(x = drawerWidth.roundToInt(), y = contentTop.roundToInt())
        }
    }
}

@Composable
fun rememberRootDrawerState(initial: RootDrawerLayoutValue = RootDrawerLayoutValue.Closed): RootDrawerLayoutState {
    return rememberSaveable(saver = RootDrawerSaver) {
        RootDrawerLayoutState(initial = initial)
    }
}
