package com.purnendu.compose.loginUi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.purnendu.compose.R

class LoginUI : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            Navigation()
        }
    }
}

@Composable
fun Navigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login_screen")
    {
        composable(route = "login_screen")
        {
            LoginScreen(navController = navController)
        }
        composable(route = "signup_screen")
        {
            SignUpUI(navController = navController)
        }
    }

}


@Composable
fun LoginScreen(navController: NavController) {

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
                text = "Login",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                modifier = Modifier.clickable {
                    navController.navigate("signup_screen")
                },
                text = "Signup",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
        }

        DetailsLoginBody(modifier = Modifier.fillMaxWidth())


        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "or Login with", color = Color.Gray)
            Spacer(modifier = Modifier.height(10.dp))
            BottomSocialMediaRow()
        }


    }
}


@Composable
fun DetailsLoginBody(modifier: Modifier = Modifier) {

    Box(modifier = modifier) {

        Column(modifier = modifier) {

            Text(text = "Email", color = Color(252, 66, 123))

            CustomTextField(label = "Enter your email here")

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Password", color = Color(252, 66, 123))

            CustomTextField(label = "Enter your password here", isTrailingIconAvailable = true)

            Spacer(modifier = Modifier.height(20.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Box(modifier = Modifier
                            .size(15.dp)
                            .background(color = Color.White)) {}

                        Spacer(modifier = Modifier.width(5.dp))

                        Text(text = "Remember me", color = Color.Gray)
                    }

                    Spacer(modifier = Modifier.height(50.dp))

                    Text(text = "Forgot password", color = Color.Gray)
                }
                FloatingActionButton(
                    backgroundColor = Color(252, 66, 123),
                    shape = RoundedCornerShape(50.dp),
                    onClick = { }) {
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

























