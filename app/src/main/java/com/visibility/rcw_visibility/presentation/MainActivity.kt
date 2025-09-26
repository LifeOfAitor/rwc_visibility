package com.visibility.rcw_visibility.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.*
import androidx.wear.compose.material.*
import com.visibility.rcw_visibility.R
import com.visibility.rcw_visibility.presentation.theme.Rcw_visibilityTheme
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.tooling.preview.devices.WearDevices

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
