package com.purnendu.compose.unityGaming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.purnendu.compose.R
import com.purnendu.compose.loginUi.LoginScreen
import com.purnendu.compose.loginUi.SignUpUI

class UnityGamingUi : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Navigation()
        }

    }
}

@Composable
fun UnityGamingFirstPage(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(31, 33, 40, 255))
            .padding(vertical = 25.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        //This is the TopBar portion
        Row(
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(id = R.drawable.menu),
                tint = Color.White,
                contentDescription = "menu"
            )
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(id = R.drawable.ic_bell),
                tint = Color.White,
                contentDescription = "menu"
            )
        }

         //This is the middle portion
        UnityGamingFirstPageBody()

        //This is the BottomBar portion
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {

            FloatingActionButton(
                modifier = Modifier.size(30.dp),
                onClick = { },
                backgroundColor =Color(124,64,255,255),
                contentColor = Color.White
            ) {
                Icon(Icons.Filled.Add,"")
            }

            Icon(
                modifier = Modifier
                    .size(20.dp)
                    .clickable {
                               navController.navigate("unity_gaming_second_screen")
                    },
                painter = painterResource(id = R.drawable.pentagon),
                tint = Color.White,
                contentDescription = "pentagon"
            )

            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(id = R.drawable.search),
                tint = Color.White,
                contentDescription = "search"
            )
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(id = R.drawable.user),
                tint = Color.White,
                contentDescription = "profile"
            )


        }

    }
}


//For navigating to different page
@Composable
fun Navigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "unity_gaming_first_screen")
    {
        composable(route = "unity_gaming_first_screen")
        {
           UnityGamingFirstPage(navController = navController)
        }
        composable(route = "unity_gaming_second_screen")
        {
            UnityGamingSecondPage(navController = navController)
        }
    }

}


