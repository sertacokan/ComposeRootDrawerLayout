package com.example.rootdrawerlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.rootdrawerlayout.ui.theme.RootDrawerLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RootDrawerLayoutContent()
        }
    }

    @Composable
    private fun RootDrawerLayoutContent() {
        val rootDrawerLayoutState = rememberRootDrawerState()
        RootDrawerLayout(
            rootDrawerLayoutState = rootDrawerLayoutState,
            drawerContent = {
                OutlinedButton(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Home")
                }
                OutlinedButton(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Profile")
                }
                OutlinedButton(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Settings")
                }
            }
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
    }


    @Preview
    @Composable
    fun RootDrawerLayoutContentPreview() {
        RootDrawerLayoutContent()
    }
}
