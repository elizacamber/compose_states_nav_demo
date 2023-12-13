package com.elizacamber.featurethree

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
internal fun FeatureThreeRoute() {
    FeatureThreeScreen()
}

@Composable
private fun FeatureThreeScreen() {
    Column (modifier = Modifier.fillMaxSize()) {
        Text("Feature Three Screen", modifier = Modifier.fillMaxSize().background(Color.Magenta))
    }
}
