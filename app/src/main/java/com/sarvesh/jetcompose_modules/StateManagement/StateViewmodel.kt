package com.sarvesh.jetcompose_modules.StateManagement

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StateViewmodel
@Inject
    constructor() : ViewModel() {

        var name: MutableState<String> = mutableStateOf("Samar")
}