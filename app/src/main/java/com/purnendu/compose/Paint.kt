package com.purnendu.compose

import android.os.Bundle
import android.view.MotionEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Slider
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.unit.dp


private var paths = mutableListOf<PathState>()

class Paint : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    SingleColor(
                        color = Color.Yellow,
                        //   modifier = Modifier.clickable { pathColor = Color.Yellow }
                    )
                    SingleColor(
                        color = Color.Green,
                        //  modifier = Modifier.clickable { pathColor = Color.Green }
                    )
                    SingleColor(
                        color = Color.Cyan
                        //   modifier = Modifier.clickable { pathColor = Color.Cyan }
                    )
                }
                Spacer(Modifier.height(25.dp))
                PaintInScreen()

//                Slider(value = pathWidth,
//                    valueRange = 10f..20f,
//                    onValueChange = { pathWidth = it })
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PaintInScreen() {


    val currentPath = Path()
    val movePath = remember { mutableStateOf<Offset?>(null) }


    Canvas(modifier = Modifier
        .fillMaxSize()
        .pointerInteropFilter {
            when (it.action) {
                MotionEvent.ACTION_DOWN -> {
                    currentPath.moveTo(it.x, it.y)

                }
                MotionEvent.ACTION_MOVE -> {
                    movePath.value = Offset(it.x, it.y)
                }
                else -> {
                    movePath.value = null
                }
            }
            true
        }
    ) {
        movePath.value?.let {
            currentPath.lineTo(it.x, it.y)
            drawPath(
                path = currentPath,
                color = Color.Black,
                style = Stroke(10f)
            )
        }
        paths.forEach {
            drawPath(
                path = it.path,
                color = it.color,
                style = Stroke(10f)
            )
        }
    }
}

@Composable
fun SingleColor(color: Color, modifier: Modifier = Modifier) {
    Canvas(modifier = modifier)
    {
        drawCircle(
            center = center + Offset(0f, 25f),
            color = color,
            radius = 60f
        )
    }
}

data class PathState(val path: Path, val color: Color, val stroke: Stroke)