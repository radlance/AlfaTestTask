package com.radlance.alfatesttask.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(
    navigationState: NavigationState,
    modifier: Modifier = Modifier
) {
    val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()
    val items = listOf(CardSearch, History)

    NavigationBar(modifier = modifier) {
        items.forEach { navigationItem ->
            val selected = navBackStackEntry?.destination?.hierarchy?.any {
                it.route == navigationItem::class.qualifiedName
            } ?: false

            NavigationBarItem(
                selected = selected,
                onClick = {
                    if (!selected) {
                        navigationState.navigateTo(navigationItem)
                    }
                },
                icon = {
                    Icon(
                        if (selected) navigationItem.selectedIcon else navigationItem.icon,
                        contentDescription = null
                    )
                }
            )
        }
    }
}