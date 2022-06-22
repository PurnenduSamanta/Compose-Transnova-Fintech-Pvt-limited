package com.purnendu.compose.customUiComponent

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.abs
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun CustomCircularSlider() {
    var radius by remember {
        mutableStateOf(0f)
    }

    var shapeCenter by remember {
        mutableStateOf(Offset.Zero)
    }

    var handleCenter by remember {
        mutableStateOf(Offset.Zero)
    }

    var angle by remember {
        mutableStateOf(90.0)
    }

    var value by remember {
        mutableStateOf(0)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box {

            Canvas(
                modifier = Modifier
                    .size(200.dp)
                    .pointerInput(key1 = Unit) {
                        detectDragGestures { change, dragAmount ->

                            if (abs(change.position.x.toInt() - handleCenter.x.toInt()) > 100)
                                return@detectDragGestures
                            if (abs(change.position.y.toInt() - handleCenter.y.toInt()) > 100)
                                return@detectDragGestures

                            handleCenter += dragAmount
                            angle = getRotationAngle(handleCenter, shapeCenter)
                            Log.d("ANGLE", "getRotationAngle: $angle")
                            value =
                                if (angle >= 90 && angle < 360) (((angle - 90) / 360) * 100).toInt()
                                else (((angle + 270) / 360) * 100).toInt()
                            change.consume()
                        }

//                        detectTapGestures{
//                            Log.d("Touch", "x^2+y^2=${((it.x)*(it.x))+((it.y)*(it.y))}")
//                            Log.d("Touch", "r^2=${radius*radius}")
//                        }
                    }


            ) {

                shapeCenter = center
                radius = size.minDimension / 2

                val x = (shapeCenter.x + cos(Math.toRadians(angle)) * radius).toFloat()
                val y = (shapeCenter.y + sin(Math.toRadians(angle)) * radius).toFloat()

                handleCenter = Offset(x, y)


                drawCircle(
                    center = center,
                    color = Color.Gray.copy(alpha = 0.10f),
                    style = Stroke(20f),
                    radius = radius
                )
                drawArc(
                    color = Color.Blue,
                    startAngle = 90f,
                    sweepAngle = if (angle >= 0.0 && angle < 90.0) {
                        (angle + 270).toFloat()
                    } else (angle - 90).toFloat(),
                    useCenter = false,
                    style = Stroke(40f, cap = StrokeCap.Round)
                )

                drawCircle(color = Color.Cyan, center = handleCenter, radius = 40f)

            }


        }



        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "$value",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )

        Slider(
            value = value.toFloat(),
            onValueChange = { },
            valueRange = 0f..100f,
        )
    }


}

private fun getRotationAngle(currentPosition: Offset, center: Offset): Double {
    val (dx, dy) = currentPosition - center
    val theta = atan2(dy, dx).toDouble()
    var angle = Math.toDegrees(theta)
    if (angle < 0) {
        angle += 360.0
    }
    return angle
}