package com.purnendu.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

class ComposeState : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            Column(Modifier.fillMaxSize()) {

                val color = remember { mutableStateOf(Color.Green) }
                val updateColorLambda: (color: Color) -> Unit = { color.value = it }
                ColorBox(
                    Modifier
                        .fillMaxSize()
                        .weight(1f),
//                    updatedColor =
//                    {
//                        color.value = it
//                    }

                    updateColorLambda


                )

                Box(
                    Modifier
                        .fillMaxSize()
                        .background(color.value)
                        .weight(1f)
                ) {

                }
            }


        }
    }

    @Composable
    private fun ColorBox(
        modifier: Modifier,
        updatedColor: (Color) -> Unit
    ) {

        Box(modifier = modifier
            .background(Color.Red)
            .clickable {
                updatedColor(
                    Color(
                        Random.nextFloat(),
                        Random.nextFloat(),
                        Random.nextFloat()
                    )
                )
            })

        {

        }
    }
}
