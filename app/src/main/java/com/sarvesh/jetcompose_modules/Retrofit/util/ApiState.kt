package com.sarvesh.jetcompose_modules.Retrofit.util

import com.sarvesh.jetcompose_modules.Retrofit.PostDTO

sealed class ApiState{

    class Success(val data:List<PostDTO> ) : ApiState()
    class Failure(val msg:Throwable) : ApiState()
    object Loading : ApiState()
    object Empty : ApiState()
}
