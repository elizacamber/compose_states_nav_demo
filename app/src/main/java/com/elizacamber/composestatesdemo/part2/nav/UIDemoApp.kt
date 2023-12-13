package com.elizacamber.composestatesdemo.part2.nav

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun UIDemoApp(appState: UIDemoAppState = rememberUIDemoAppState()) {
    Scaffold(
        bottomBar = {
            if (appState.shouldShowBottomBar) {
                UIDemoBottomBar(
                    destinations = appState.bottomBarDestinations,
                    onNavigateToDestination = appState::navigateToBottomBarDestination,
                    currentDestination = appState.currentDestination
                )
            }

        }
    ) { paddingValues ->
        Row(
            Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .consumeWindowInsets(paddingValues)
        ) {
            UIDemoNavHost(appState)
        }
    }
}