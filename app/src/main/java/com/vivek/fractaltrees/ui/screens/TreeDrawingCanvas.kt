package com.vivek.fractaltrees.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun TreeDrawingCanvas(
    modifier: Modifier,
    branchColor: Color,
    branchLength: Float,
    treeDepth: Int,
    branchAngleDifference: Float
) {
    Canvas(modifier = modifier.fillMaxWidth()) {
        val canvasHeight = size.height
        val center = size.center

        // trunk is -90 degree to go upwards not downward
        val branchAngle = -(PI / 2)

        drawTree(
            start = Offset(center.x, canvasHeight),
            end = Offset(x = center.x, y = canvasHeight - branchLength),
            depth = treeDepth,
            branchLength = branchLength,
            branchAngle = branchAngle,
            angleDifference = branchAngleDifference,
            branchColor = branchColor
        )
    }
}

/**
 * @param start is the starting point of branch
 * @param end is the ending point of branch
 * @param depth is the level of tree, more depth -> more dense tree
 * @param branchLength, trunk is the first branch, then it reduces by some fraction
 * @param branchAngle, angle from X axis the branch is making
 * @param angleDifference is used like: (PI/angleDifference) as angle between two branches
 * @param branchColor is the color of branches
 */
fun DrawScope.drawTree(
    start: Offset,
    end: Offset,
    depth: Int,
    branchLength: Float,
    branchAngle: Double,
    angleDifference: Float,
    branchColor: Color
) {
    if (depth == 0) return

    drawLine(
        start = start,
        end = end,
        color = branchColor,
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
            angleDifference = angleDifference,
            branchColor = branchColor
        )
    }

    // Right branch
    branch(angle = branchAngle + branchAngleDifference)
    // Left branch
    branch(angle = branchAngle - branchAngleDifference)
}