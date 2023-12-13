package com.elizacamber.featurethree

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val featureThreeRoute = "feature_three_route"

fun NavController.navigateToFeatureThree(navOptions: NavOptions? = null) {
    this.navigate(featureThreeRoute, navOptions)
}

fun NavGraphBuilder.featureThreeScreen() {
    composable(route = featureThreeRoute) {
        FeatureThreeRoute()
    }
}