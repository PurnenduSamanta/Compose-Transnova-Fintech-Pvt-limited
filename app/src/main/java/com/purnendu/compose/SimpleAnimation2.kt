package com.purnendu.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


enum class State {
    START, END
}


class SimpleAnimation2 : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ScaleAnimationScreen()
        }
    }

    @Composable
    fun VisibilityAnimationScreen() {

        var visible by remember {
            mutableStateOf(false)
        }
        Column {
            AnimatedVisibility(
                visible = visible,
                enter = expandHorizontally() + fadeIn(animationSpec = tween(3000, 100)),
                exit = shrinkHorizontally() + fadeOut()
            ) {
                Text(text = "Hello Jetpack Compose")
            }
            Button(
                onClick = { visible = !visible },
                modifier = Modifier
                    .fillMaxSize()
                    //.align(alignment =Alignment.Start)
                    .wrapContentSize(align = Alignment.BottomCenter)
                    .padding(16.dp)
            ) {
                Text(text = "Animate")

            }
        }

    }

    @Composable
    fun SizeAnimationScreen() {
        var state by remember {
            mutableStateOf(State.START)
        }
        val offset: Dp by animateDpAsState(targetValue = if (state == State.START) 5.dp else 300.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioHighBouncy,
            stiffness = Spring.StiffnessLow

        ))

        Column(modifier = Modifier.fillMaxSize()) {
            MyAnimatedObject(offset = offset)
            Button(
                onClick = {
                    state = when (state) {
                        State.START -> State.END
                        State.END -> State.START
                    }
                },
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(align = Alignment.BottomCenter)
                    .padding(16.dp)
            ) {
                Text(text = "Animate")

            }
        }

    }

    @Composable
    fun ScaleAnimationScreen() {
        var state by remember {
            mutableStateOf(State.START)
        }
        val scale: Float by animateFloatAsState(targetValue = if (state == State.START) 1f else 10f,
            animationSpec = keyframes {
                durationMillis=1000
                5f.at(400).with(FastOutLinearInEasing)
                delayMillis=100
            })

        Column(modifier = Modifier.fillMaxSize()) {
            MyAnimatedObject(scale =scale )
            Button(
                onClick = {
                    state = when (state) {
                        State.START -> State.END
                        State.END -> State.START
                    }
                },
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(align = Alignment.BottomCenter)
                    .padding(16.dp)
            ) {
                Text(text = "Animate")

            }
        }

    }

    @Composable
    fun MyAnimatedObject(
        modifier: Modifier = Modifier,
        offset: Dp=0.dp,
        color: Color = Color.Red,
        scale:Float=1f
    ) {
        Surface(
            modifier = modifier
                .size(50.dp)
                .padding(start = 16.dp)
                .absoluteOffset(y = offset)
                .scale(scale),
            color = color,
        ) {

        }


    }
}