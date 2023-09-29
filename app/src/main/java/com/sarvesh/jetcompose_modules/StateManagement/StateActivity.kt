package com.sarvesh.jetcompose_modules.StateManagement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sarvesh.jetcompose_modules.ui.theme.JetCompose_ModulesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StateActivity : ComponentActivity() {

    private val stateViewmodel : StateViewmodel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetCompose_ModulesTheme() {
                Surface(color = MaterialTheme.colors.background) {
                    ShowWidgets(stateViewmodel)
                }
            }
        }
    }

    @Composable
    fun ShowWidgets(stateViewmodel: StateViewmodel) {
        //remember keeps the data but in case of change in state it lost
        // so we can use rememberSaveable to keep data in case of change in state (its a buldle use to store data)
        var name = rememberSaveable{
            mutableStateOf("")
        }
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (stateViewmodel.name.value.isNotEmpty()){
                Text(text = stateViewmodel.name.value, color = Color.Green)
            }
            OutlinedTextField(value = stateViewmodel.name.value, onValueChange = {
                stateViewmodel.name.value = it
            },
                label = {
                    Text(text = "Name")
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

}