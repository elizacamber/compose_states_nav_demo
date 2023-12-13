package com.elizacamber.composestatesdemo.part2.nav

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navOptions
import com.elizacamber.featureone.featureOneRoute
import com.elizacamber.featureone.navigateToFeatureOne
import com.elizacamber.featurethree.featureThreeRoute
import com.elizacamber.featurethree.navigateToFeatureThree
import com.elizacamber.featuretwo.featureTwoRoute
import com.elizacamber.featuretwo.navigateToFeatureTwo

//10

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
        @Composable get() = currentDestination?.route == "msg" //19

    val bottomBarDestinations: List<BottomBarDestination> = BottomBarDestination.values().asList()

    fun navigateToBottomBarDestination(bottomBarDestination: BottomBarDestination) {
        val bottomBarNavOptions = navOptions {
            //18
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