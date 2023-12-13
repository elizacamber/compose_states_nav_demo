package com.elizacamber.composestatesdemo.part2.nav

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy

//7
@Composable
fun UIDemoBottomBar(
    destinations: List<BottomBarDestination>,
    //9
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier,
) {
    NavigationBar(
        modifier = modifier,
    ) {
        destinations.forEach { destination ->
            val selected = currentDestination.isBottomBarDestinationInHierarchy(destination)
            NavigationBarItem(
                selected = selected,
                onClick = { }, //8
                icon = {
                    Icon(imageVector = destination.icon, contentDescription = stringResource(id = destination.titleTextId))
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = destination.selectedColor,
                    unselectedIconColor = destination.unselectedColor
                )
            )
        }
    }
}

private fun NavDestination?.isBottomBarDestinationInHierarchy(destination: BottomBarDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false