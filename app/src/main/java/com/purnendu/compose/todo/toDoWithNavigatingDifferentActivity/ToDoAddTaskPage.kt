package com.purnendu.compose.todo.toDoWithNavigatingDifferentActivity


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.purnendu.compose.todo.Task
import com.purnendu.compose.todo.listOfTask


class ToDoAddTaskPage : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val context = LocalContext.current
                val intent = (context as ToDoAddTaskPage).intent
                val listIndex=intent.getIntExtra("TASK_INDEX",-1)
                TopAppBar(
                    title = { Text(text = "ToDo") },
                    backgroundColor = Color.Red,
                    contentColor = Color.White
                )

                Column(
                    modifier = Modifier
                        .padding(horizontal = 30.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {

                    val task=(if (listIndex==-1) "" else listOfTask[listIndex].task)
                    val dueDate=(if (listIndex==-1) "" else listOfTask[listIndex].dueDate)
                    var desc by remember { mutableStateOf(task) }
                    var date by remember { mutableStateOf(dueDate) }
                    Text(
                        text = "Add Your Task",
                        fontSize = 30.sp,
                    )
                    TextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = desc,
                        onValueChange = { desc = it },
                        placeholder = { Text(text = "Task") }
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    TextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = date,
                        onValueChange = { date = it },
                        placeholder = { Text(text = "Due date") },
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            if(listIndex==-1)
                            {
                                if (desc.isNotEmpty() && date.isNotEmpty()) {
                                    listOfTask.add(Task(desc, date))
                                }
                            }
                            else
                            {
                                if (desc.isNotEmpty() && date.isNotEmpty()) {
                                    listOfTask[listIndex].task = desc
                                    listOfTask[listIndex].dueDate = date
                                }
                            }
                            val intent1 = Intent(context, ToDoWithNavigation::class.java)
                            intent1.flags =
                                Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(intent1)


                        }
                    ) {
                        Text(if(listIndex==-1) "Add" else "Update")
                    }


                }


            }


        }
    }


}