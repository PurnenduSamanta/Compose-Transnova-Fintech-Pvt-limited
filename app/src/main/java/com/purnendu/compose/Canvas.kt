package com.purnendu.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

class Canvas : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyCanvas()
        }
    }

    @Composable
    fun MyCanvas() {

        Canvas(
            modifier =
            Modifier
                .padding(20.dp)
                .size(300.dp)
        )
        {
            drawRect(
                color = Color.Black,
                size = size
            )

            drawRect(
                color = Color.Red,
                topLeft = Offset(100f, 100f),
                size = Size(100f, 100f),
                style = Stroke(
                    width = 2.dp.toPx()
                )
            )
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(Color.Red, Color.Green),
                    center = center, radius = 100f
                ),
                radius = 100f,
                center = center
            )
            drawArc(
                color = Color.Blue,
                startAngle = 0f,
                sweepAngle = 90f,
                useCenter =true,
                topLeft = Offset(100f,500f),
                size = Size(200f,200f)
            )

            drawOval(
               color = Color.Magenta,
               topLeft = Offset(500f,100f),
                size = Size(200f,300f)
            )

            drawLine(
                color = Color.Cyan,
                start = Offset(0f,0f),
                end = Offset(100f,100f),
                strokeWidth = 3.dp.toPx()
            )
        }
    }
}