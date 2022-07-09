package com.purnendu.compose.unityGaming

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.purnendu.compose.R

@Composable
fun UnityGamingSecondPage(navController: NavController) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(31, 29, 46, 255)),
        verticalArrangement = Arrangement.Top
    ) {

        //Upper portion
        Column(
            modifier = Modifier
                .weight(0.5f)  //giving this child 50% height
                .fillMaxWidth()
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    modifier = Modifier
                        .size(20.dp)
                        .clickable {
                            navController.navigate("unity_gaming_first_screen")
                        },
                    imageVector = Icons.Default.ArrowBack,
                    tint = Color.White,
                    contentDescription = "icon"
                )

                Row {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        imageVector = Icons.Default.Done,
                        tint = Color.White,
                        contentDescription = "icon"
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    Icon(
                        modifier = Modifier.size(20.dp),
                        painter = painterResource(id = R.drawable.like),
                        tint = Color.White,
                        contentDescription = "icon"
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    Icon(
                        modifier = Modifier.size(20.dp),
                        painter = painterResource(id = R.drawable.ic_bell),
                        tint = Color.White,
                        contentDescription = "icon"
                    )
                }

            }


            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                text = "Unity Gaming",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Image(
                    modifier = Modifier
                        .size(50.dp)
                        .aspectRatio(1f, matchHeightConstraintsFirst = true)
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.avatar3),
                    contentDescription = "avatar"
                )

                Column {
                    Text(text = "Assigned to", color = Color.Gray)
                    Text(text = "Tam Taran", color = Color.White)
                }

                FloatingActionButton(
                    modifier = Modifier.size(50.dp),
                    onClick = { },
                    backgroundColor = Color(25, 94, 228, 255),
                    contentColor = Color.White
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.calender),
                        tint = Color.White,
                        contentDescription = "icon"
                    )
                }

                Column {
                    Text(text = "Due Date", color = Color.Gray)
                    Text(text = "Sep 20", color = Color.White)
                }

            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                text = "Description", color = Color.White
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                text = "We're a growing family of 345,345 designers and makers from around the world",
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(20.dp))

            LazyRow(contentPadding = PaddingValues(horizontal = 20.dp)) {
                items(count = 2)
                {
                    Card(shape = RoundedCornerShape(10.dp)) {
                        Image(
                            modifier = Modifier
                                .width(170.dp)
                                .height(120.dp),
                            painter = painterResource(id = R.drawable.cartoon),
                            contentDescription = "avatar"
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }


        }

        //Below Card portion
        UnityGamingSecondPageBelowSection(
            modifier = Modifier
                .weight(0.35f)  //giving this child 40% height
        )
    }


}