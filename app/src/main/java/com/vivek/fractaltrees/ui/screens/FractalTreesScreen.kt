package com.vivek.fractaltrees.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.vivek.fractaltrees.ui.theme.SliderBGColorActive

@Composable
fun FractalTreesScreen() {
    var branchLength by remember { mutableStateOf(300f) }
    var treeDepth by remember { mutableStateOf(1f) }
    var branchAngle by remember { mutableStateOf(0f) }

    Column(modifier = Modifier.fillMaxSize()) {
        TreeDrawingCanvas(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally),
            branchLength = branchLength,
            treeDepth = treeDepth.toInt(),
            branchAngleDifference = branchAngle
        )

        Text(text = "Branch Length")

        Slider(
            value = branchLength,
            onValueChange = { branchLength = it },
            valueRange = 300f..500f,
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colors.onBackground,
                activeTrackColor = SliderBGColorActive
            )
        )

        Text(text = "Tree Depth")

        Slider(
            value = treeDepth,
            onValueChange = { treeDepth = it },
            valueRange = 1f..15f,
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colors.onBackground,
                activeTrackColor = SliderBGColorActive
            )
        )

        Text(text = "Branch Angle")

        Slider(
            value = branchAngle,
            onValueChange = { branchAngle = it },
            valueRange = 0f..0.35f,
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colors.onBackground,
                activeTrackColor = SliderBGColorActive
            )
        )
    }
}




















