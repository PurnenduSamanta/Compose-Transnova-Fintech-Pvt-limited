package com.purnendu.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class SimpleAnimation : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

            var sizeState by remember {
                mutableStateOf(200.dp)
            }

            val size by animateDpAsState(
                targetValue = sizeState,
                animationSpec = tween(
                    durationMillis = 500,
                    delayMillis = 300,
                    easing = LinearEasing
                )
                //  animationSpec = spring(Spring.DampingRatioHighBouncy)

//                animationSpec = keyframes {
//                    durationMillis = 5000
//                    sizeState at 0 with LinearEasing
//
//                    sizeState * 1.5f at 1000 with FastOutLinearInEasing
//
//                    sizeState * 2f at 5000
//                }
            )

            val infiniteTransition = rememberInfiniteTransition()
            val color by infiniteTransition.animateColor(
                initialValue = Color.Green,
                targetValue = Color.Blue,
                animationSpec = InfiniteRepeatableSpec(
                    tween(
                        durationMillis = 3000,
                        delayMillis = 300,
                        easing = LinearEasing
                    )
                )
            )
            Box(
                modifier = Modifier
                    .size(size)
                    .background(color),
                contentAlignment = Alignment.Center
            ) {

                Button(onClick = { sizeState += 50.dp }) {

                    Text(text = "Increase Size")

                }

            }


        }


    }
}