package com.purnendu.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp

class TextComposable : ComponentActivity() {

    private val fontFamily = FontFamily(
        Font(R.font.sarkowik, weight = FontWeight.Normal),
        Font(R.font.digital_geometric_bold, weight = FontWeight.Normal, style = FontStyle.Italic),
    )

    private val textStyle = TextStyle(
        color = Color.Red,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Italic,
        fontFamily = fontFamily,
        textDecoration = TextDecoration.Underline
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Box()
            {
                Text(
                    text = "Hello world dxvxvxdddddddddddddddddddddddddddddddddddddddddddd",
                    color = Color.Red,
                    fontSize = 40.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.W300,
                    letterSpacing = 20.sp,
                    textDecoration = TextDecoration.combine(
                        listOf(
                            TextDecoration.Underline,
                            TextDecoration.LineThrough
                        )
                    ),
                    textAlign = TextAlign.Left,
                    lineHeight = 80.sp,
                    overflow = TextOverflow.Ellipsis,
                   // maxLines = 1,
                   // fontFamily = FontFamily.Cursive
                    fontFamily=fontFamily,
                    softWrap = false,
                  //  style = textStyle
                )

            }
        }
    }
}