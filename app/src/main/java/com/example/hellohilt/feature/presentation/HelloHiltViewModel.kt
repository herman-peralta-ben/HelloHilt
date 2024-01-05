package com.example.hellohilt.feature.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hellohilt.feature.data.repositories.HelloHiltRepositoryImpl
import com.example.hellohilt.feature.domain.repositories.HelloHiltRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HelloHiltViewModel(
    private val repository: HelloHiltRepository
): ViewModel() {
    private val _state = MutableStateFlow("Hello Hilt")
    val state = _state.asStateFlow()

    fun increment() {
        _state.value = repository.increment().toString()
    }

    companion object {
        // https://developer.android.com/topic/libraries/architecture/viewmodel/viewmodel-factories
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>
            ): T {
                // Get the Application object from extras
                return HelloHiltViewModel(
                    HelloHiltRepositoryImpl()
                ) as T
            }
        }
    }
}
