package com.example.zengarden

import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.zengarden.auth.presentation.AuthScreen
import com.example.zengarden.auth.presentation.AuthViewModel
import com.example.zengarden.core.navigation.NavRoutes
import com.example.zengarden.core.network.JwtManager
import com.example.zengarden.plants.presentation.PlantsScreen
import com.example.zengarden.ui.theme.ZenGardenTheme
import org.koin.androidx.compose.koinViewModel
import java.util.concurrent.Executor


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            ZenGardenTheme {
                Scaffold(modifier = Modifier
                    .fillMaxSize()
                    .background(ZenGardenTheme.colors.surface)
                ) { innerPadding ->

                    val jwtManager = JwtManager(applicationContext)
                    //jwtManager.clearToken()
                    val token = jwtManager.getToken()


                    val startDestination = if (token == null) NavRoutes.auth else NavRoutes.plants

                    NavHost(navController, startDestination = startDestination) {
                        composable(NavRoutes.auth) {
                            AuthScreen(
                                viewModel = koinViewModel(),
                                paddingValues = innerPadding,
                                onRegisterSuccess = {
                                    navController.navigate(NavRoutes.plants) {
                                        popUpTo(NavRoutes.auth){
                                            inclusive = true
                                        }
                                    }
                                },
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(ZenGardenTheme.colors.surface)
                            )
                        }
                        composable(NavRoutes.plants) {
                            PlantsScreen(
                                viewModel = koinViewModel(),
                                onUnauth = {
                                    navController.navigate(NavRoutes.auth) {
                                        popUpTo(NavRoutes.plants){
                                            inclusive = true
                                        }
                                    }
                                },
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