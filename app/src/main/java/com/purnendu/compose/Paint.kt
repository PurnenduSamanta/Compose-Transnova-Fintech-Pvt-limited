package com.purnendu.compose

import android.os.Bundle
import android.view.MotionEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Slider
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.unit.dp



private class PathState(val path: Path, val color: Color, val stroke: Stroke)


private val pathList = mutableListOf<PathState>()
private var action by mutableStateOf<Double?>(null)
private var color by mutableStateOf(Color.Black)
private var strokeWidth by mutableStateOf(10f)
private var path = Path()

class Paint : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.1f)
                        .clip(RoundedCornerShape(bottomEnd = 50.dp, bottomStart = 50.dp))
                        .background(color = Color.Magenta),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SingleSelectedColor(
                        color = Color.Yellow,
                        modifier = Modifier.clickable { color = Color.Yellow }
                    )
                    SingleSelectedColor(
                        color = Color.Green,
                        modifier = Modifier.clickable { color = Color.Green }
                    )
                    SingleSelectedColor(
                        color = Color.Cyan,
                        modifier = Modifier.clickable { color = Color.Cyan }
                    )
                    SingleSelectedColor(
                        color = Color.White,
                        modifier = Modifier.clickable {
                            pathList.clear() //Clearing the list
                            color=Color.Black// Set default color to black
                            action = Math.random() //For recomposing the canvas
                        }
                    )
                }
                PaintInScreen(
                    modifier = Modifier
                        .fillMaxHeight(.9f)
                        .fillMaxWidth()
                        .padding(vertical = 10.dp)
                )
                Slider(value = strokeWidth,
                    valueRange = 10f..20f,
                    onValueChange = { strokeWidth = it },
                )
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PaintInScreen(modifier: Modifier = Modifier) {

    Canvas(modifier = modifier
        .pointerInteropFilter {

            when (it.action) {
                MotionEvent.ACTION_DOWN -> {
                    path.moveTo(it.x, it.y)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    action = Math.random()
                    path.lineTo(it.x, it.y)
                    true
                }
                MotionEvent.ACTION_UP -> {
                    //Adding path to the list
                    pathList.add(PathState(path, color, Stroke(width = strokeWidth)))
                    //Creating new Path object
                    path = Path()
                    //Recomposing Canvas
                    action = Math.random()
                    true
                }
                else -> {
                    false
                }
            }
        }
    ) {
        action?.let {

            //It will draw a path when ACTION_MOVE
            drawPath(
                path = path,
                color = color,
                style = Stroke(width = strokeWidth)
            )

            //It will draw list of paths when ACTION_UP and override previous path
            pathList.forEach {
                drawPath(
                    path = it.path,
                    color = it.color,
                    style = it.stroke
                )

            }
        }

    }
}

@Composable
fun SingleSelectedColor(color: Color, modifier: Modifier = Modifier) {
    Canvas(modifier = modifier)
    {
        drawCircle(
            center = center + Offset(0f, 0f),
            color = color,
            radius = 60f
        )
    }
}
