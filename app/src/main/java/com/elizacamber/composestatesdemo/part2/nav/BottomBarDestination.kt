package com.elizacamber.composestatesdemo.part2.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.elizacamber.composestatesdemo.R

enum class BottomBarDestination(
    val icon: ImageVector,
    val selectedColor: Color,
    val unselectedColor: Color,
    val titleTextId: Int,
) {
    FEATURE_ONE(
        icon = Icons.Default.DateRange,
        selectedColor = Color.Blue,
        unselectedColor = Color.Gray,
        titleTextId = R.string.bottom_1
    ),
    FEATURE_TWO(
        icon = Icons.Default.DateRange,
        selectedColor = Color.Blue,
        unselectedColor = Color.Gray,
        titleTextId = R.string.bottom_2
    ),
    FEATURE_THREE(
        icon = Icons.Default.DateRange,
        selectedColor = Color.Blue,
        unselectedColor = Color.Gray,
        titleTextId = R.string.bottom_3
    ),
}
