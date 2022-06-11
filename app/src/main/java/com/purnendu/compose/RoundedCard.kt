package com.purnendu.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.purnendu.compose.ui.theme.ComposeTheme

class RoundedCard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val painterResource = painterResource(id = R.drawable.pic)
            val title = "JetPack Compose"
            val content = "This is my first project"
            Box(
                Modifier
                    .fillMaxWidth(0.5f)
                    .padding(10.dp)
            ) {
                ImageCard(painter = painterResource, title = title, content = content)
            }
        }
    }

    @Composable
    fun ImageCard(painter: Painter, title: String, content: String, modifier: Modifier = Modifier) {


        Card(
            modifier = modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            elevation = 5.dp
        ) {


            Box(modifier = Modifier.height(200.dp))
            {
                Image(
                    painter = painter,
                    contentDescription = content,
                    contentScale = ContentScale.Crop
                )
                Box(
                    Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black
                                ),
                                startY = 300f
                            )
                        )
                ) {

                }


                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp),
                    contentAlignment = Alignment.BottomStart
                )
                {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Green,
                                    fontSize = 30.sp
                                ),
                            )
                            {
                                append("J")
                            }
                            append("etpack")
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Green,
                                    fontSize = 30.sp
                                ),
                            )
                            {
                                append("C")
                            }
                            append("ompose")
                        },
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,

                        )
                    )
                }

            }

        }


    }
}

