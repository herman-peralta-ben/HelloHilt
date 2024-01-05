package com.example.hellohilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.hellohilt.feature.presentation.HelloHiltScreen
import com.example.hellohilt.feature.presentation.HelloHiltViewModel
import com.example.hellohilt.ui.theme.HelloHiltTheme

class MainActivity : ComponentActivity() {

    private val viewModel: HelloHiltViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloHiltTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HelloHiltScreen(viewModel)
                }
            }
        }
    }
}
