package com.elizacamber.composestatesdemo.part2.nav

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.elizacamber.featureone.featureOneRoute
import com.elizacamber.featureone.navigateToFeatureOne
import com.elizacamber.featurethree.featureThreeRoute
import com.elizacamber.featurethree.navigateToFeatureThree
import com.elizacamber.featuretwo.featureTwoRoute
import com.elizacamber.featuretwo.navigateToFeatureTwo

@Composable
fun rememberUIDemoAppState(
    navController: NavHostController = rememberNavController(),
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
): UIDemoAppState {
    return remember(navController) {
        UIDemoAppState(navController = navController, snackbarHostState = snackbarHostState)
    }
}

class UIDemoAppState(
    val navController: NavHostController,
    val snackbarHostState: SnackbarHostState
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val currentBottomBarDestination: BottomBarDestination?
        @Composable get() = when (currentDestination?.route) {
            featureOneRoute -> BottomBarDestination.FEATURE_ONE
            featureTwoRoute -> BottomBarDestination.FEATURE_TWO
            featureThreeRoute -> BottomBarDestination.FEATURE_THREE
            else -> null
        }

    val shouldShowBottomBar: Boolean
        @Composable get() = currentDestination?.route == "msg"
                || currentDestination?.route == featureOneRoute


    val bottomBarDestinations: List<BottomBarDestination> = BottomBarDestination.values().asList()

    fun navigateToBottomBarDestination(bottomBarDestination: BottomBarDestination) {
        val bottomBarNavOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        when (bottomBarDestination) {
            BottomBarDestination.FEATURE_ONE -> navController.navigateToFeatureOne(
                bottomBarNavOptions
            )

            BottomBarDestination.FEATURE_TWO -> navController.navigateToFeatureTwo(
                bottomBarNavOptions
            )

            BottomBarDestination.FEATURE_THREE -> navController.navigateToFeatureThree(
                bottomBarNavOptions
            )
        }
    }

    fun navigateToMessage() {
        navController.navigate("msg")
    }

}