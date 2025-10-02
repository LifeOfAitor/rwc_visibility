package com.visibility.rcw_visibility.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.TimeText
import androidx.wear.tooling.preview.devices.WearDevices
import com.visibility.rcw_visibility.presentation.theme.Rcw_visibilityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Rcw_visibilityTheme {
                WearApp()
            }
        }
    }
}
@Preview(device = WearDevices.SMALL_ROUND, showSystemUi = true)
@Composable
fun WearApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(onNavigate = {
                navController.navigate("activity_selection")
            })
        }
        composable("activity_selection") {
            ActivitySelectionScreen()
        }
    }
}

@Composable
fun HomeScreen(onNavigate: () -> Unit) {
    Scaffold(
        timeText = { TimeText() }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Hola desde Wear OS!")
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = onNavigate) {
                Text("Ir a actividades")
            }
        }
    }
}

@Composable
fun ActivitySelectionScreen() {
    Scaffold(
        timeText = { TimeText() }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Elige una actividad:")
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = { /* Acción Running */ }) {
                Text("🏃 Running")
            }
            Spacer(modifier = Modifier.height(6.dp))
            Button(onClick = { /* Acción Cycling */ }) {
                Text("🚴 Cycling")
            }
            Spacer(modifier = Modifier.height(6.dp))
            Button(onClick = { /* Acción Walking */ }) {
                Text("🚶 Walking")
            }
        }
    }
}
