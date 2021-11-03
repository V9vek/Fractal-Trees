package com.vivek.fractaltrees

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.vivek.fractaltrees.ui.screens.FractalTreesScreen
import com.vivek.fractaltrees.ui.theme.FractalTreesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FractalTreesTheme {
                Surface(color = MaterialTheme.colors.background) {
                    FractalTreesScreen()
                }
            }
        }
    }
}
