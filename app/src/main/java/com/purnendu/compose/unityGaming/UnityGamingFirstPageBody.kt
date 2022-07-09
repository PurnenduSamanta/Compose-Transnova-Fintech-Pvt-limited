package com.purnendu.compose.unityGaming

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.purnendu.compose.R

@Composable
fun UnityGamingFirstPageBody(modifier: Modifier = Modifier) {

    Column(modifier = modifier.padding(horizontal = 15.dp)) {

        Text(text = "Recent Projects", color = Color.White)

        Spacer(modifier = Modifier.heightIn(20.dp))

        //For two cards
        CardLayout(cardCount = 2)

        Spacer(modifier = Modifier.heightIn(30.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(text = "Recently Assigned", color = Color.White)

            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(id = R.drawable.control),
                tint = Color.White,
                contentDescription = "menu"
            )

        }

        Spacer(modifier = Modifier.height(25.dp))

        //Individual recent card
        SingleRecentCard(
            icon = painterResource(id = R.drawable.done),
            upperText = "Create Unity", lowerText = "GuideStyle",
            date = "Tomorrow",
            upperTextColor = Color(101,255,167,255),
            lowerTextColor = Color(101,255,167,255),
            dateColor = Color(101,255,167,255)
        )

        Spacer(modifier = Modifier.height(10.dp))

        SingleRecentCard(
            icon = painterResource(id = R.drawable.progress1),
            upperText = "Unity Dashboard", lowerText = "Symbol adjustments",
            date = "Sep7",
            upperTextColor = Color.White,
            lowerTextColor = Color.LightGray,
            dateColor = Color(184, 151, 223, 255)
        )
        Spacer(modifier = Modifier.height(10.dp))

        SingleRecentCard(
            icon = painterResource(id = R.drawable.progress2),
            upperText = "Collab Landing Page", lowerText = "Screen adjustment",
            date = "Sep8",
            upperTextColor = Color.White,
            lowerTextColor = Color.LightGray,
            dateColor = Color(108, 202, 214, 255)
        )


    }
}

@Composable
fun CardLayout(cardCount: Int) {

    LazyRow()
    {
        items(count = cardCount)
        {

            SingleCard(
                cardTopLine = "Skillaley", cardDescription = "UI design kit",
                avatarsList = listOf(
                    painterResource(id = R.drawable.avatar4),
                    painterResource(id = R.drawable.avatar3),
                    painterResource(id = R.drawable.avatar2)
                )
            )
            Spacer(modifier = Modifier.width(20.dp))
        }

    }
}

@Composable
fun SingleCard(
    cardTopLine: String,
    cardDescription: String,
    avatarsList: List<Painter>,
) {


    Card(
        backgroundColor = Color(37, 105, 252, 255),
        shape = RoundedCornerShape(
            topStart = 15.dp, topEnd = 30.dp,
            bottomStart = 30.dp, bottomEnd = 30.dp
        ),
        elevation = 20.dp,
        modifier = Modifier
            .height(200.dp)
            .width(300.dp)
    ) {

        Column(modifier = Modifier.padding(30.dp)) {

            Text(
                text = cardTopLine,
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.heightIn(10.dp))
            Text(text = cardDescription, color = Color.White, fontSize = 20.sp)
            Spacer(modifier = Modifier.heightIn(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {


                Row(
                    modifier = Modifier.width(110.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier.width(60.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            modifier = Modifier
                                .size(50.dp)
                                .aspectRatio(1f, matchHeightConstraintsFirst = true)
                                .clip(CircleShape),
                            painter = avatarsList[0],
                            contentDescription = "avatar1"
                        )
                        Image(
                            modifier = Modifier
                                .size(50.dp)
                                .aspectRatio(1f, matchHeightConstraintsFirst = true)
                                .clip(CircleShape),
                            painter = avatarsList[1],
                            contentDescription = "avatar2"
                        )
                    }

                    Image(
                        modifier = Modifier
                            .size(50.dp)
                            .aspectRatio(1f, matchHeightConstraintsFirst = true)
                            .clip(CircleShape),
                        painter = avatarsList[2],
                        contentDescription = "avatar2"
                    )

                }


                Spacer(modifier = Modifier.width(60.dp))

                Column(
                    horizontalAlignment = Alignment.Start
                ) {

                    Text(text = "Progress", color = Color.White, fontSize = 15.sp)
                    Slider(
                        value = 5f, onValueChange = {},
                        colors = SliderDefaults.colors(
                            thumbColor = Color.White,
                            activeTrackColor = Color.White,
                            inactiveTrackColor = Color(128, 142, 155)
                        ),
                        valueRange = 0f..10f
                    )

                }


            }


        }

    }


}


@Composable
fun SingleRecentCard(
    modifier: Modifier = Modifier,
    icon: Painter,
    upperText: String,
    lowerText: String,
    date: String,
    upperTextColor: Color,
    lowerTextColor: Color,
    dateColor: Color
) {

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        backgroundColor = Color(41, 46, 60, 255),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {


            Row(verticalAlignment = Alignment.CenterVertically) {

                Image(
                    modifier = Modifier.size(30.dp),
                    painter = icon,
                    contentDescription = "icon",
                )

                Spacer(modifier = Modifier.width(20.dp))

                Column() {
                    Text(text = upperText, color = upperTextColor)
                    Text(text = lowerText, color = lowerTextColor)
                }

            }


            Spacer(modifier = Modifier.width(40.dp))

            Text(text = date, color = dateColor)


        }
    }


}

