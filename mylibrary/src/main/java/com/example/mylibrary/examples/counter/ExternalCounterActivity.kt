package com.example.mylibrary.examples.counter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExternalCounterActivity : ComponentActivity() {
    companion object {
        fun getStartIntent(context: Context) = Intent(
            context, ExternalCounterActivity::class.java
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val viewModel: ExternalCounterViewModel = hiltViewModel()
            CounterScreen(viewModel)
        }
    }
}
