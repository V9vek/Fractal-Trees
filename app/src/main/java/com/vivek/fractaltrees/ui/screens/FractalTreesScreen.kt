package com.vivek.fractaltrees.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vivek.fractaltrees.ui.screens.components.CustomHeader
import com.vivek.fractaltrees.ui.screens.components.CustomSlider

@Composable
fun FractalTreesScreen(
    isDarkTheme: Boolean,
    onThemeToggled: (Boolean) -> Unit
) {
    var branchLength by remember { mutableStateOf(300f) }
    var treeDepth by remember { mutableStateOf(2f) }
    var branchAngle by remember { mutableStateOf(0f) }

    Column(modifier = Modifier.fillMaxSize()) {
        CustomHeader(
            isDarkMode = isDarkTheme,
            onThemeToggled = onThemeToggled
        )

        TreeDrawingCanvas(
            modifier = Modifier
                .padding(8.dp)
                .weight(1f)
                .align(Alignment.CenterHorizontally),
            branchColor = MaterialTheme.colors.onBackground,
            branchLength = branchLength,
            treeDepth = treeDepth.toInt(),
            branchAngleDifference = branchAngle
        )

        CustomSlider(
            sliderText = "Branch Length",
            sliderValue = branchLength,
            onSliderValueChange = { branchLength = it },
            valueRange = 300f..500f
        )

        CustomSlider(
            sliderText = "Tree Depth",
            sliderValue = treeDepth,
            onSliderValueChange = { treeDepth = it },
            valueRange = 2f..15f
        )

        CustomSlider(
            sliderText = "Branch Angle",
            sliderValue = branchAngle,
            onSliderValueChange = { branchAngle = it },
            valueRange = 0f..0.35f
        )
    }
}




















