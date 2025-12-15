package com.example.mylibrary.examples.counter

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ExternalCounterViewModel @Inject constructor(
    private val counter: ExternalCounter,
) : ViewModel() {

    private val _state = MutableStateFlow(counter.value)
    val state = _state.asStateFlow()

    fun increment() {
        _state.value = counter.increment()
    }

    fun decrement() {
        _state.value = counter.decrement()
    }
}
