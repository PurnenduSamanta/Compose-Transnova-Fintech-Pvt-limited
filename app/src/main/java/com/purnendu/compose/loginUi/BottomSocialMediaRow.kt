package com.purnendu.compose.loginUi

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.purnendu.compose.R

@Composable
fun BottomSocialMediaRow() {

    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {

        SingleSocialMediaIcon(painter = painterResource(id = R.drawable.twitter))
        Spacer(modifier = Modifier.width(50.dp))
        SingleSocialMediaIcon(painter = painterResource(id = R.drawable.facebook))
        Spacer(modifier = Modifier.width(50.dp))
        SingleSocialMediaIcon(painter = painterResource(id = R.drawable.google))
    }
}

@Composable
fun SingleSocialMediaIcon(painter: Painter, modifier: Modifier = Modifier) {
    Image(
        painter = painter, contentDescription = "Image",
        modifier = modifier
            .size(40.dp)
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .clip(CircleShape)
            .background(color = Color.White)
            .padding(10.dp)

    )
}

@Preview
@Composable
fun Test() {
    BottomSocialMediaRow()
}