package com.purnendu.compose.customUiComponent

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.math.sin
import kotlin.random.Random

class RotatoryWheel : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                var frequency by remember {
                    mutableStateOf(0)
                }

                val infiniteTransition = rememberInfiniteTransition()
                val angle by infiniteTransition.animateFloat(
                    initialValue = 0f,
                    targetValue = frequency.toFloat() * 360f,
                    animationSpec = infiniteRepeatable(
                       animation =
                       tween(durationMillis = 1000, easing = LinearEasing),
                        repeatMode =RepeatMode.Restart
                    )
                )

                Log.d("frequency", angle.toString())

                Text(
                    text = "LIFE IS A \n BEAUTIFUL",
                    fontSize = 40.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Italic
                )

                Spacer(modifier = Modifier.height(50.dp))

                Wheel(
                    modifier = Modifier
                        .graphicsLayer {
                            rotationZ = angle
                        },
             //           .border(color = Color.Black, width = 1.dp),
                    spokeNo = 15
                )

                Spacer(modifier = Modifier.height(20.dp))

//                Text(
//                    text = "$frequency Hz",
//                    fontWeight = FontWeight.SemiBold,
//                    fontSize = 30.sp
//                )

                Slider(
                    value = frequency.toFloat(),
                    onValueChange = {
                        frequency = it.roundToInt()
                    },
                    valueRange = 0f..5f,
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "RIDE",
                    fontSize = 40.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Italic
                )
            }

        }
    }
}

@Composable
fun Wheel(
    modifier: Modifier = Modifier,
    spokeNo: Int = 12
) {

    Canvas(modifier = modifier.size(300.dp))
    {

        val center = center
        val radius = size.height / 2

        drawCircle(
            center = center,
            color = Color.Black,
            style = Stroke(2f),
            radius = radius
        )

        drawCircle(
            center = center,
            color = Color.Black,
            style = Stroke(20f),
            radius = radius + 30f
        )


        val spokes: Int = if (spokeNo < 12 || spokeNo >= 25)
            12
        else
            findNearestSpokeNo(spokeNo)
        val incrementAngle = 360 / spokes
        var angle = 0.0
        while (angle < 360.0) {
            val x = (center.x + cos(Math.toRadians(angle)) * radius).toFloat()
            val y = (center.y + sin(Math.toRadians(angle)) * radius).toFloat()


            drawLine(
                color = Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat()
                ),
                start = center,
                end = Offset(x, y),
                strokeWidth = 5f
            )
            angle += incrementAngle.toFloat()
        }

    }
}

private fun findNearestSpokeNo(spokeNo: Int): Int {
    var spokes = spokeNo
    if (360 % spokes != 0) {
        spokes++
        spokes = findNearestSpokeNo(spokes)
    }
    return spokes
}

