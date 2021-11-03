package com.vivek.fractaltrees

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.vivek.fractaltrees.ui.screens.FractalTreesScreen
import com.vivek.fractaltrees.ui.theme.FractalTreesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDarkTheme by remember { mutableStateOf(true) }

            FractalTreesTheme(isDarkTheme) {
                Surface(color = MaterialTheme.colors.background) {
                    FractalTreesScreen(
                        isDarkTheme = isDarkTheme,
                        onThemeToggled = { isDarkTheme = it }
                    )
                }
            }
        }
    }
}
