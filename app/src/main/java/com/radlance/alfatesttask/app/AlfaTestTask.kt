package com.radlance.alfatesttask.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.radlance.alfatesttask.navigation.BottomNavigationBar
import com.radlance.alfatesttask.navigation.NavGraph
import com.radlance.alfatesttask.navigation.rememberNavigationState

@Composable
fun AlfaTestTask() {
    val navController = rememberNavController()
    val navigationState = rememberNavigationState(navController)

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navigationState)
        },
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        NavGraph(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}