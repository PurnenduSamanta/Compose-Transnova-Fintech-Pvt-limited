package com.purnendu.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.purnendu.compose.ui.theme.ComposeTheme

class BasicTextField :ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val text = remember { mutableStateOf("Hello world") }
                    Box {
                        BasicTextField(
                            value = text.value,
                            onValueChange = {
                                text.value = it
                            },
                            decorationBox = { innerTextField ->
                                Row(
                                    Modifier
                                        .background(Color.LightGray, RoundedCornerShape(percent = 40))
                                        .padding(16.dp)
                                ){
                                    Icon(Icons.Default.MailOutline, contentDescription = "")
                                    Spacer(Modifier.width(16.dp))
                                    innerTextField()
                                }
                            },
                            cursorBrush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Red,
                                    Color.Blue
                                )
                            )
                        )
                    }
                }
            }
        }
    }
}