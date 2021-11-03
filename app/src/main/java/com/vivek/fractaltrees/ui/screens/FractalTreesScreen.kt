package com.vivek.fractaltrees.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
fun FractalTreesScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .border(width = 1.dp, color = Color.Red)
        ) {
            val canvasWidth = size.width
            val canvasHeight = size.height
            val center = size.center
            val trunkLength = 300f               // first branch is trunk
            val depth = 4                        // depth or levels
            val branchAngle =
                -(PI.div(2))             // trunk is -90 degree to go upwards not downward

            drawTree(
                start = Offset(center.x, canvasHeight),
                end = Offset(x = center.x, y = canvasHeight - trunkLength),
                depth = depth,
                branchLength = trunkLength,
                branchAngle = branchAngle
            )
        }
    }
}

fun DrawScope.drawTree(
    start: Offset,
    end: Offset,
    depth: Int,
    branchLength: Float,
    branchAngle: Double
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
    val branchAngleDifference = (PI / 4)

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
            branchAngle = angle
        )
    }

    // Right branch
    branch(angle = branchAngle + branchAngleDifference)
    // Left branch
    branch(angle = branchAngle - branchAngleDifference)
}




















