package com.elizacamber.composestatesdemo.part2.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.elizacamber.composestatesdemo.Dashboard
import com.elizacamber.composestatesdemo.ui.MsgInputBar

@Composable
fun UIDemoNavHost(
    navController: NavHostController, // 16
    modifier: Modifier = Modifier,
    startDestination: String = "dashboard",
) {
    //17
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        // !!! DO NOT NAME THE ROUTES HERE LIKE THIS! DEMO PURPOSES ONLY
        composable("dashboard") { Dashboard { navController.navigate("msg") } }
        composable("msg") { MsgInputBar() }

        //5
    }
}