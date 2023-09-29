package com.sarvesh.jetcompose_modules.Retrofit

import com.sarvesh.jetcompose_modules.Retrofit.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainRepository
@Inject
constructor(private val apiService: ApiService) {

    fun getPost():Flow<List<PostDTO>> = flow {
        emit(apiService.getPost())
    }.flowOn(Dispatchers.IO)

}