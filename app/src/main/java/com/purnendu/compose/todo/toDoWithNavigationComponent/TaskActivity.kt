package com.purnendu.compose.todo.toDoWithNavigationComponent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class TaskActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            Column(modifier = Modifier
                .fillMaxSize()) {

                TopAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    title = { Text(text = "ToDo") },
                    backgroundColor = Color.Red,
                    contentColor = Color.White
                )
                Navigation()
            }

        }
    }

    @Composable
    fun Navigation() {

        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "page_task_list")
        {
            composable(route = "page_task_list")
            {
                TaskList(navController = navController)
            }
            composable(route = "add_task_page?index={index}",
                arguments = listOf(
                    navArgument("index")
                    {
                        type = NavType.IntType
                        defaultValue = -1
                        nullable = false
                    }
                )
            )
            {
                it.arguments?.let { it1 ->
                    AddTask(
                        navController = navController,
                        listIndex = it1.getInt("index")
                    )
                }
            }
        }

    }
}