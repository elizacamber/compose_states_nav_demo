package com.elizacamber.composestatesdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.elizacamber.composestatesdemo.ui.MsgInputBar
import com.elizacamber.composestatesdemo.ui.theme.ComposeStatesDemoTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStatesDemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    // !!! DO NOT NAME THE ROUTES HERE LIKE THIS! DEMO PURPOSES ONLY
                    NavHost(navController = navController, startDestination = "dashboard") {
                        composable("dashboard") { Dashboard { navController.navigate("msg") } }
                        composable("msg") { MsgInputBar() }
                    }

                    //4
                }
            }
        }
    }
}

@Composable
fun Dashboard(navToMsg: () -> Unit) {
    Column {
        Button(onClick = navToMsg) {
            Text(text = "Message screen")
        }
    }
}