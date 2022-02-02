package com.example.rootdrawerlayout.sample

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.rootdrawerlayout.RootDrawerLayoutState

@Composable
fun Content(
    rootDrawerLayoutState: RootDrawerLayoutState
) {
    Column {
        TopAppBar(
            modifier = Modifier.fillMaxWidth(),
            title = { Text(text = "") },
            navigationIcon = {
                IconButton(onClick = { rootDrawerLayoutState.toggle() }) {
                    Icon(imageVector = Icons.Outlined.Menu, contentDescription = null)
                }
            })
        Text(text = "Content text", modifier = Modifier.fillMaxSize())
    }
}
