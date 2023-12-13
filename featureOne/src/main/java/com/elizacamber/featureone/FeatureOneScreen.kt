package com.elizacamber.featureone

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
internal fun FeatureOneRoute() {
    FeatureOneScreen()
}

@Composable
private fun FeatureOneScreen() {
    Column (modifier = Modifier.fillMaxSize()) {
        Text("Feature One Screen", modifier = Modifier.fillMaxSize().background(Color.Green))
    }
}
