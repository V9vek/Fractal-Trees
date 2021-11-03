package com.vivek.fractaltrees.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.dp
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun TreeDrawingCanvas(
    modifier: Modifier,
    branchLength: Float,
    treeDepth: Int,
    branchAngleDifference: Float
) {
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .border(width = 1.dp, color = Color.Red)
    ) {
        val canvasHeight = size.height
        val center = size.center

//        val trunkLength = 300f               // first branch is trunk
//        val depth = 4                        // depth or levels
        val branchAngle = -(PI / 2)     // trunk is -90 degree to go upwards not downward

        drawTree(
            start = Offset(center.x, canvasHeight),
            end = Offset(x = center.x, y = canvasHeight - branchLength),
            depth = treeDepth,
            branchLength = branchLength,
            branchAngle = branchAngle,
            angleDifference = branchAngleDifference
        )
    }
}

fun DrawScope.drawTree(
    start: Offset,
    end: Offset,
    depth: Int,
    branchLength: Float,
    branchAngle: Double,
    angleDifference: Float
) {
    if (depth == 0) return

    drawLine(
        start = start,
        end = end,
        color = Color.White,
        strokeWidth = 5f
    )

    // decreasing branch length by (2/3) ratio everytime
    val nextBranchLength = branchLength * 0.67f
    val branchAngleDifference = (PI) * angleDifference

    fun branch(angle: Double) {
        val nextEndOffset = Offset(
            x = (end.x + (nextBranchLength * cos(angle))).toFloat(),
            y = (end.y + (nextBranchLength * sin(angle))).toFloat()
        )

        drawTree(
            start = end,
            end = nextEndOffset,
            depth = depth - 1,
            branchLength = nextBranchLength,
            branchAngle = angle,
            angleDifference = angleDifference
        )
    }

    // Right branch
    branch(angle = branchAngle + branchAngleDifference)
    // Left branch
    branch(angle = branchAngle - branchAngleDifference)
}