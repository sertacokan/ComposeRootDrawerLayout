package com.example.rootdrawerlayout.sample

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.rootdrawerlayout.RootDrawerLayout
import com.example.rootdrawerlayout.rememberRootDrawerState

@Composable
fun RootDrawerLayoutContent() {
    val rootDrawerLayoutState = rememberRootDrawerState()

    RootDrawerLayout(
        rootDrawerLayoutState = rootDrawerLayoutState,
        drawerContent = { DrawerContent() },
        content = { Content(rootDrawerLayoutState) }
    )
}


@Preview
@Composable
fun RootDrawerLayoutContentPreview() {
    RootDrawerLayoutContent()
}
