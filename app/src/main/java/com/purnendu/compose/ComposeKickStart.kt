package com.purnendu.compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.purnendu.compose.ui.theme.ComposeTheme

class ComposeKickStart : ComponentActivity() {
    private val textValue = mutableStateOf("")
    private val resultValue = mutableStateOf("")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background

                ) {
                    val context = LocalContext.current
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            TextField(
                                value = textValue.value,
                                onValueChange = {
                                    textValue.value = it
                                },
                                label = {
                                    Text("Number")
                                },
                                placeholder = {
                                    Text("Give a number")
                                },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number
                                ),
                                modifier = Modifier.fillMaxWidth()
                            )
                            Button(
                                shape = RoundedCornerShape(3.dp),
                                border = BorderStroke(2.dp, Color.Green),
                                onClick = {
                                    if (textValue.value.isNotEmpty()) {
                                        try {
                                            resultValue.value =
                                                (textValue.value.toInt() * 2).toString()
                                        } catch (e: Exception) {
                                            Toast.makeText(context, "Bad Input", Toast.LENGTH_SHORT)
                                                .show()
                                        }
                                    } else {
                                        Toast.makeText(context, "Bad Input", Toast.LENGTH_SHORT)
                                            .show()
                                    }
                                }) {
                                Text("Get Double")
                            }
                            Text(resultValue.value)
                        }

                    }

                }
            }
        }
    }
}