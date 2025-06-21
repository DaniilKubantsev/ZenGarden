package com.example.zengarden

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.zengarden.auth.presentation.AuthScreen
import com.example.zengarden.auth.presentation.AuthViewModel
import com.example.zengarden.ui.theme.ZenGardenTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZenGardenTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AuthScreen(
                        viewModel = viewModel(),
                        paddingValues = innerPadding,
                        modifier = Modifier
                            .fillMaxSize()
                            .background(ZenGardenTheme.colors.surface)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ZenGardenTheme.colors.primary)
    ) {
        Text(
            text = "Hello $name!",
            modifier = modifier,
            style = MaterialTheme.typography.displayLarge,
            color = ZenGardenTheme.colors.title
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ZenGardenTheme {
        Greeting("Android")
    }
}