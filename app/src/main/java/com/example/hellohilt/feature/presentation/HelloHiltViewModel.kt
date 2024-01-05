package com.example.hellohilt.feature.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HelloHiltViewModel: ViewModel() {
    private val _state = MutableStateFlow("Hello Hilt")
    val state = _state.asStateFlow()

    private var count = 0

    fun increment() {
        count += 1
        _state.value = count.toString()
    }
}
