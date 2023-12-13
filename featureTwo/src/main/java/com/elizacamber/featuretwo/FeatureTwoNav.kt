package com.elizacamber.featuretwo

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val featureTwoRoute = "feature_two_route"

fun NavController.navigateToFeatureTwo(navOptions: NavOptions? = null) {
    this.navigate(featureTwoRoute, navOptions)
}

fun NavGraphBuilder.featureTwoScreen() {
    composable(route = featureTwoRoute) {
        FeatureTwoRoute()
    }
}