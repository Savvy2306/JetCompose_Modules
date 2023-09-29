package com.sarvesh.jetcompose_modules.Retrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.sarvesh.jetcompose_modules.Retrofit.util.ApiState
import com.sarvesh.jetcompose_modules.ui.theme.JetCompose_ModulesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RetrofitActivity : ComponentActivity() {

    private val mainViewmodel : MainViewmodel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetCompose_ModulesTheme {
                Surface(color = MaterialTheme.colors.background) {
                    GetData(mainViewmodel = mainViewmodel)
                }
            }
        }
    }

    @Composable
    fun EachRow(post: PostDTO){
        Card (
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth(),
            elevation = 5.dp,
            shape = RoundedCornerShape(CornerSize(10.dp))
        ){
            Row(modifier = Modifier.padding(5.dp)) {
                Text(
                    text = post.body,
                    modifier = Modifier.padding(10.dp),
                    fontStyle = FontStyle.Italic
                )
            }

        }
    }

    //function to get data
    @Composable
    fun GetData(mainViewmodel: MainViewmodel) {
        when(val result = mainViewmodel.response.value){
            is ApiState.Success->{
                LazyColumn{
                    items(result.data){post->
                        EachRow(post)
                    }
                }
            }
            is ApiState.Failure->{
                Text(text = "${result.msg}")
            }
            ApiState.Loading->{
                CircularProgressIndicator()
            }
            ApiState.Empty->{

            }
        }
    }

}