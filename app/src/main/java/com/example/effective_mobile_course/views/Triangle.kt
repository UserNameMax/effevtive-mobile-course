package com.example.effective_mobile_course.views

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

@Composable
fun triangle(color: Color, modifier: Modifier = Modifier) {
    val height = LocalConfiguration.current.screenHeightDp
    val width = LocalConfiguration.current.screenWidthDp
    val proportion = 0.5f

    Canvas(
        modifier = modifier.background(Color.Red),
    ) {
        val path = Path()
        path.moveTo(width.dp.toPx(), height.dp.toPx()*proportion) // A
        path.lineTo(0f, height.dp.toPx())                    // B
        path.lineTo(width.dp.toPx(), height.dp.toPx())          // C
        path.lineTo(width.dp.toPx(), height.dp.toPx()*proportion) // A
        path.close()
        drawPath(path = path, color = color)
    }
}
