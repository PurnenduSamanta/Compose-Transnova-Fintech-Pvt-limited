package com.purnendu.compose.todo.toDoWithNavigatingDifferentActivity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.purnendu.compose.todo.listOfTask


class ToDoWithNavigation : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                val context = LocalContext.current


                Column {
                    TopAppBar(
                        title = { Text(text = "ToDo") },
                        backgroundColor = Color.Red,
                        contentColor = Color.White
                    )


                    GridLayout(modifier = Modifier.padding(10.dp)) {
                        val intent = Intent(context, ToDoAddTaskPage::class.java)
                        intent.putExtra("TASK_INDEX",it)
                        startActivity(intent)
                    }
                }



                FloatingActionButton(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(end = 10.dp, bottom = 10.dp)
                        .size(50.dp),
                    onClick = {
                        context.startActivity(Intent(context, ToDoAddTaskPage::class.java))
                    }) {

                    Icon(Icons.Filled.Add, "")

                }

            }


        }
    }


    @Composable
    fun GridLayout(
        modifier: Modifier = Modifier,
        fn: (index: Int) -> Unit
    ) {
        LazyVerticalGrid(
            modifier = modifier,
            columns = GridCells.Fixed(2),
        )
        {

            items(listOfTask.size)
            {
                SingleTask(
                    taskDesc = listOfTask[it].task,
                    dueDate = listOfTask[it].dueDate,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { fn(it) }
                )

            }
        }
    }


    @Composable
    fun SingleTask(
        modifier: Modifier = Modifier,
        taskDesc: String,
        dueDate: String
    ) {
        Card(
            modifier = modifier
                .padding(3.dp),
            elevation = 3.dp,
            shape = RoundedCornerShape(3.dp),
            border = BorderStroke(1.dp, color = Color.Green)
        ) {

            Column(
                modifier = Modifier
                    .padding(5.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = taskDesc)
                Spacer(modifier = Modifier.height(3.dp))
                Text(text = dueDate)
            }
        }
    }
}
