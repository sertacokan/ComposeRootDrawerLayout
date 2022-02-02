package com.example.rootdrawerlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.rootdrawerlayout.sample.RootDrawerLayoutContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RootDrawerLayoutContent()
        }
    }
}
