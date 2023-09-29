package com.sarvesh.jetcompose_modules.ToDo

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.sarvesh.jetcompose_modules.ToDo.dto.ToDoDTO
import com.sarvesh.jetcompose_modules.ui.theme.JetCompose_ModulesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoActivity : ComponentActivity() {

    private val todoViewmodel : TodoViewmodel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetCompose_ModulesTheme {
                Surface(color = MaterialTheme.colors.background) {
                    AddToolbar(todoViewmodel)
                }
            }
        }
    }

    @Composable
    fun AddToolbar(todoViewmodel: TodoViewmodel) {
        Scaffold(
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        IconButton(onClick = { }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    },
                    title = {
                        Text(text = "ToDo App")
                    },
                    actions = {
                        IconButton(onClick = { }) {
                            Icon(Icons.Default.Notifications, contentDescription = "notification")
                        }
                    }
                )
            },
            floatingActionButton = {

                val openDialog = remember {
                    mutableStateOf(false)
                }

                FloatingActionButton(onClick = {openDialog.value = true }) {
                    AddDialog(openDialog = openDialog)
                        Icon(Icons.Default.Add, contentDescription = "Add")

                }
            },
            content = {it
                recyclerView(todoViewmodel = todoViewmodel)
            }
        )
    }

    @Composable
    fun AddDialog(openDialog:MutableState<Boolean>) {
        val title = remember {
            mutableStateOf("")
        }
        val description = remember {
            mutableStateOf("")
        }

        if (openDialog.value) {
            AlertDialog(
                title = {
                    Text(text = "ToDO")
                },
                text = {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            value = title.value,
                            onValueChange = { title.value = it },
                            label = {
                                Text(text = "title")
                            },
                            placeholder = {
                                Text(text = "Enter Title")
                            },
                            modifier = Modifier.padding(10.dp)
                        )
                        OutlinedTextField(
                            value = description.value,
                            onValueChange = { description.value = it },
                            label = {
                                Text(text = "description")
                            },
                            placeholder = {
                                Text(text = "Enter Description")
                            },
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                },
                buttons = {
                    OutlinedButton(onClick = {
                        insert(title,description)
                        openDialog.value = false
                    }) {
                        Text(text = "Save")
                    }
                },
                onDismissRequest = {
                    openDialog.value = false
                }
            )
        }
    }

    private fun insert(title:MutableState<String>,description:MutableState<String>){
        lifecycleScope.launchWhenStarted {
            if (!TextUtils.isEmpty(title.value) && !TextUtils.isEmpty(description.value)){
                todoViewmodel.insertTodo(
                    ToDoDTO(
                        title.value,
                        description.value
                    )
                )
                Toast.makeText(this@TodoActivity,"Inserted...",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this@TodoActivity,"Empty...",Toast.LENGTH_SHORT).show()
            }
        }

    }

    @Composable
    fun eachRow(toDoDTO: ToDoDTO){
        Card(modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
            elevation = 5.dp,
            shape = RoundedCornerShape(5.dp)
        ) {
            Column(modifier = Modifier.padding(10.dp)) {
                Text(text = toDoDTO.title, fontWeight = FontWeight.ExtraBold)
                Text(text = toDoDTO.description, fontStyle = FontStyle.Italic)
            }
        }
    }
    
    @Composable
    fun recyclerView(todoViewmodel: TodoViewmodel){
        LazyColumn {
            items(todoViewmodel.response.value){todo->
                eachRow(toDoDTO = todo)
            }
        }
    }
}