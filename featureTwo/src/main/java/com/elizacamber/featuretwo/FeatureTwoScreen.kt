package com.elizacamber.featuretwo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
internal fun FeatureTwoRoute() {
    FeatureTwoScreen()
}

@Composable
private fun FeatureTwoScreen() {
    Column (modifier = Modifier.fillMaxSize()) {
        Text("Feature Two Screen", modifier = Modifier.fillMaxSize().background(Color.LightGray))
    }
}
