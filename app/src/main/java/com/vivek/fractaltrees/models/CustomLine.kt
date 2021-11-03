package com.vivek.fractaltrees.models

import androidx.compose.ui.geometry.Offset

data class CustomLine(
    val startOffset: Offset,
    val endOffset: Offset,
    val length: Int,
    val angle: Int
)

// TODO: length and angle can be editable
