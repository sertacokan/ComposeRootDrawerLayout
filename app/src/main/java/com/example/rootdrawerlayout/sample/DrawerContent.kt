package com.example.rootdrawerlayout.sample

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DrawerContent() {
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
