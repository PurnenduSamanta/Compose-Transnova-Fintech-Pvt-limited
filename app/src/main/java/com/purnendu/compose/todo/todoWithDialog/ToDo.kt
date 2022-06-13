package com.purnendu.compose.todo.todoWithDialog

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
import androidx.compose.ui.unit.dp
import com.purnendu.compose.todo.Task
import com.purnendu.compose.todo.listOfTask

class ToDo : ComponentActivity() {

    private val showDialog = mutableStateOf(false)
    private val showEditDialog = mutableStateOf(false)
    private val selectedIndex = mutableStateOf(-1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                if (showDialog.value) {
                    InputAlertDialog()
                }

                if (showEditDialog.value) {
                    EditNoteAlertDialog()
                }


                Column {
                    TopAppBar(
                        title = { Text(text = "ToDo") },
                        backgroundColor = Color.Red,
                        contentColor = Color.White
                    )


                    GridLayout(modifier = Modifier.padding(10.dp)) {
                        selectedIndex.value = it
                        showEditDialog.value = true
                    }
                }



                FloatingActionButton(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(end = 10.dp, bottom = 10.dp)
                        .size(50.dp),
                    onClick = {
                        showDialog.value = true
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
            border = BorderStroke(1.dp,color = Color.Green)
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

    @Composable
    fun InputAlertDialog() {

        var desc by remember { mutableStateOf("") }
        var date by remember { mutableStateOf("") }
        AlertDialog(
            title = {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                )
                {
                    Text(
                        text = "Add your Task",
                    )
                }

            },
            text = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextField(
                        value = desc,
                        onValueChange = { desc = it },
                        placeholder = { Text(text = "Task") }
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    TextField(
                        value = date,
                        onValueChange = { date = it },
                        placeholder = { Text(text = "Due date") },
                    )
                }
            },
            onDismissRequest = {
                showDialog.value = false
            },
            buttons = {
                Row(
                    modifier = Modifier.padding(all = 8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            if (desc.isNotEmpty() && date.isNotEmpty()) {
                                listOfTask.add(Task(desc, date))
                            }
                            showDialog.value = false
                        }
                    ) {
                        Text("Add")
                    }
                }

            }
        )
    }

    @Composable
    fun EditNoteAlertDialog() {

        var desc by remember { mutableStateOf(listOfTask[selectedIndex.value].task) }
        var date by remember { mutableStateOf(listOfTask[selectedIndex.value].dueDate) }
        AlertDialog(
            title = {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                )
                {
                    Text(
                        text = "Add your Task",
                    )
                }

            },
            text = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextField(
                        value = desc,
                        onValueChange = { desc = it },
                        placeholder = { Text(text = "Task") }
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    TextField(
                        value = date,
                        onValueChange = { date = it },
                        placeholder = { Text(text = "Due date") }
                    )
                }
            },
            onDismissRequest = {
                showEditDialog.value = false
            },
            buttons = {
                Row(
                    modifier = Modifier.padding(all = 8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            listOfTask[selectedIndex.value].task = desc
                            listOfTask[selectedIndex.value].dueDate = date
                            showEditDialog.value = false
                        }
                    ) {
                        Text("Add")
                    }
                }

            }
        )
    }
}