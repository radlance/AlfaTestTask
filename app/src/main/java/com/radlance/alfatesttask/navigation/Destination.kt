package com.radlance.alfatesttask.navigation

import androidx.annotation.Keep
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

interface BottomDestination {
    val icon: ImageVector
    val selectedIcon: ImageVector
}

@Keep
@Serializable
data object CardSearch : BottomDestination {
    override val icon: ImageVector = Icons.Outlined.Search
    override val selectedIcon: ImageVector = Icons.Filled.Search
}

@Keep
@Serializable
data object History : BottomDestination {
    override val icon: ImageVector = Icons.Outlined.History
    override val selectedIcon: ImageVector = Icons.Filled.History
}