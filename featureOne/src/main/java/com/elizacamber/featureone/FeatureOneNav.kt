package com.elizacamber.featureone

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val featureOneRoute = "feature_one_route"

fun NavController.navigateToFeatureOne(navOptions: NavOptions? = null) {
    this.navigate(featureOneRoute, navOptions)
}

fun NavGraphBuilder.featureOneScreen() {
    composable(route = featureOneRoute) {
        FeatureOneRoute()
    }
}