package com.radlance.alfatesttask.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.radlance.alfatesttask.presentation.history.HistoryScreen
import com.radlance.alfatesttask.presentation.search.CardSearch

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = CardSearch, modifier = modifier) {
        composable<CardSearch> {
            CardSearch()
        }

        composable<History> {
            HistoryScreen()
        }
    }
}