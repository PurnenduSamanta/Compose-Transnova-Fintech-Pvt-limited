package com.purnendu.compose.unityGaming

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.purnendu.compose.R


@Composable
fun UnityGamingSecondPageBelowSection(modifier: Modifier=Modifier) {

    Card(
        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        backgroundColor = Color(23, 25, 32, 255),
        modifier = modifier
    ) {

        Box(modifier = Modifier
            .padding(top = 20.dp)) {

            Column(
                modifier = Modifier
                    .padding(start = 20.dp)
            ) {

                //Individual task
                SingleTask(
                    image = painterResource(id = R.drawable.avatar4),
                    upperText = "Dash created this week",
                    belowText = "Sep 7 at 17:36"
                )
                Spacer(modifier = Modifier.height(20.dp))
                SingleTask(
                    image = painterResource(id = R.drawable.avatar2),
                    upperText = "Marina added to Premade Template",
                    belowText = "Sep 7 at 17:55"
                )
                Spacer(modifier = Modifier.height(20.dp))
                SingleTask(
                    image = painterResource(id = R.drawable.avatar3),
                    upperText = "Dash charged the due date to Sep 20",
                    belowText = "Sep 7 at 18:29"
                )

            }

            //Add a question section
            Card(
                modifier = Modifier
                    .align(Alignment.BottomCenter)  //Align it to bottom
                    .fillMaxWidth()
                    .fillMaxHeight(0.3f),

                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
                backgroundColor = Color(31, 33, 40, 255)
            ) {


                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {


                        Row(verticalAlignment = Alignment.CenterVertically) {
                            FloatingActionButton(
                                modifier = Modifier.size(30.dp),
                                onClick = { },
                                backgroundColor = Color(124, 64, 255, 255),
                                contentColor = Color.White
                            ) {
                                Icon(Icons.Filled.Add, "")
                            }
                            Spacer(modifier = Modifier.width(20.dp))
                            Text(
                                text = "Ask a question...",
                                color = Color.White,
                                fontSize = 20.sp
                            )
                        }

                        Icon(
                            modifier = Modifier.size(25.dp),
                            painter = painterResource(id = R.drawable.send),
                            tint = Color.White,
                            contentDescription = "avatar"
                        )


                    }
                }


            }

        }


    }
}

@Composable
fun SingleTask(
    image: Painter,
    upperText: String,
    belowText: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            modifier = Modifier
                .size(40.dp)
                .aspectRatio(1f, matchHeightConstraintsFirst = true)
                .clip(CircleShape),
            painter = image,
            contentDescription = "avatar"
        )

        Spacer(modifier = Modifier.width(20.dp))
        Column {

            Text(text = upperText, color = Color.White)
            Text(text = belowText, color = Color.Gray)

        }


    }


}
