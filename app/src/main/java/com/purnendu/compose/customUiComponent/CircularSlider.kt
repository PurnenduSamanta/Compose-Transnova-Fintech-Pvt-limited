package com.purnendu.compose.customUiComponent


import android.os.Bundle
import android.view.MotionEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.*

var handleCenter by mutableStateOf(Offset.Zero)
var angle by mutableStateOf(90.0)
var value by mutableStateOf(0)
var radius by mutableStateOf(0f)
var shapeCenter by mutableStateOf(Offset.Zero)


class CircularSlider : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                CustomCircularSlider()
            }
        }
    }

}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CustomCircularSlider() {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box {
            Canvas(
                modifier = Modifier
                    .size(200.dp)
                    .pointerInteropFilter {
                        when (it.action) {
                            MotionEvent.ACTION_DOWN -> {
                                var x = it.x
                                var y = it.y
                                x -= shapeCenter.x  //(x-a)
                                y -= shapeCenter.y //(y-b)  where (a,b) is center of circle
                                val a = (x * x) + (y * y)//(x-a)^2 +(y-b)^2
                                val b = radius * radius  //r^2
                                val c = abs(a - b)    //abs((x-a)^2+(y-b)^2-(r*r))
                                val d = ceil(c.toDouble()).toInt()
//
                                if (d > 15000)  // Validating touches whether it is situated on circumference or not
                                    false
                                else {
                                    setAngleValue(it.x, it.y)  //Set the angle value
                                    true
                                }

                            }
                            MotionEvent.ACTION_MOVE -> {
                                setAngleValue(it.x, it.y)  //Set the angle value
                                true
                            }
                            else -> false
                        }
                    }
                //This method is not precise ,so not recommended
//                    .pointerInput(key1 = Unit) {
//                        detectDragGestures { change, dragAmount ->
//
//                            if (abs(change.position.x.toInt() - handleCenter.x.toInt()) > 100)
//                                return@detectDragGestures
//                            if (abs(change.position.y.toInt() - handleCenter.y.toInt()) > 100)
//                                return@detectDragGestures
//
//                            handleCenter += dragAmount
//                            angle = getRotationAngle(handleCenter, shapeCenter)
//                            Log.d("ANGLE", "getRotationAngle: $angle")
//                            value =
//                                if (angle >= 90 && angle < 360) (((angle - 90) / 360) * 100).toInt()
//                                else (((angle + 270) / 360) * 100).toInt()
//                            change.consume()
//                        }
//                    }


            ) {

                radius = (size.height) / 2
                shapeCenter = center

                val x = (shapeCenter.x + cos(Math.toRadians(angle)) * radius).toFloat()
                val y = (shapeCenter.y + sin(Math.toRadians(angle)) * radius).toFloat()

                handleCenter = Offset(x, y)


                //Draw inactive circle
                drawCircle(
                    center = center,
                    color = Color.Gray.copy(alpha = 0.10f),
                    style = Stroke(20f),
                    radius = radius
                )

                //Draw active Arc
                drawArc(
                    color = Color.Blue,
                    startAngle = 90f,
                    sweepAngle = if (angle >= 0.0 && angle < 90.0) {
                        (angle + 270).toFloat()
                    } else (angle - 90).toFloat(),
                    useCenter = false,
                    style = Stroke(40f, cap = StrokeCap.Round)
                )

                //Draw handle
                drawCircle(color = Color.Cyan, center = handleCenter, radius = 40f)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "$value",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )

        //Liner slider
        Slider(
            value = value.toFloat(),
            onValueChange = { },
            valueRange = 0f..100f,
        )
    }
}

private fun setAngleValue(x: Float, y: Float) {
    handleCenter = Offset(x, y)
    angle = getRotationAngle(handleCenter, shapeCenter)
    value =
        if (angle >= 90 && angle < 360) (((angle - 90) / 360) * 100).toInt()
        else (((angle + 270) / 360) * 100).toInt()
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