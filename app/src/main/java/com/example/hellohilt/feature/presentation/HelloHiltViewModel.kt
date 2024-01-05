package com.example.hellohilt.feature.presentation

import androidx.lifecycle.ViewModel
import com.example.hellohilt.feature.domain.repositories.HelloHiltRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HelloHiltViewModel @Inject constructor(
    private val repository: HelloHiltRepository
): ViewModel() {
    private val _state = MutableStateFlow("Hello Hilt")
    val state = _state.asStateFlow()

    fun increment() {
        _state.value = repository.increment().toString()
    }

    // ViewModelProvider.Factory not required
}
