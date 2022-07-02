package com.purnendu.compose.loginUi

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.purnendu.compose.R


@Composable
fun SignUpUI(navController: NavController) {

    Column(
        modifier =
        Modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .padding(horizontal = 15.dp, vertical = 50.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Sign up",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                modifier = Modifier.clickable {
                    navController.navigate("login_screen")
                },
                text = "Login",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
        }

        DetailsSignUpBody(modifier = Modifier.fillMaxWidth())


        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "or Sign up with", color = Color.Gray)
            Spacer(modifier = Modifier.height(10.dp))
            BottomSocialMediaRow()
        }


    }

}

@Composable
fun DetailsSignUpBody(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {

        Column(modifier = modifier) {

            Text(text = "Email", color =  Color(252, 66, 123))

            CustomTextField(label = "Enter your email here")

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Password", color =  Color(252, 66, 123))

            CustomTextField(label = "Enter your password here", isTrailingIconAvailable = true)

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Confirm Password", color =  Color(252, 66, 123))

            CustomTextField(label = "Enter your password here", isTrailingIconAvailable = true)

            Spacer(modifier = Modifier.height(20.dp))


            Row(
                modifier=Modifier.fillMaxWidth(),
               horizontalArrangement = Arrangement.End,
            ) {
                FloatingActionButton(
                    backgroundColor = Color(232, 67, 147),
                    shape = RoundedCornerShape(50.dp),
                    onClick = { },
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_forward),
                        tint = Color.White,
                        contentDescription = "",
                        modifier = Modifier.size(30.dp)
                    )

                }
            }


        }

    }
}