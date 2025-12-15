package com.example.hellohilt.feature.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.mylibrary.examples.counter.ExternalCounterActivity

@Composable
fun HelloHiltScreen(viewModel: HelloHiltViewModel = hiltViewModel()) {

    val state = viewModel.state.collectAsState()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(0.5f),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = state.value, style = TextStyle(fontSize = 40.sp))
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(0.5f),
            contentAlignment = Alignment.BottomCenter,
        ) {
            Row {
                Button(onClick = { viewModel.increment() }) {
                    Text(text = "Increment")
                }

                Button(onClick = { context.startActivity(ExternalCounterActivity.getStartIntent(context)) }) {
                    Text(text = "Open External Counter")
                }
            }
        }
    }
}
