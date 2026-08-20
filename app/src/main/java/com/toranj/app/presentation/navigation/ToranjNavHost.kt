package com.toranj.app.presentation.navigation

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.navigation.compose.*
import com.toranj.app.presentation.dashboard.DashboardScreen
import com.toranj.app.presentation.tasks.TasksScreen

@Composable fun ToranjNavHost() {
    val nav = rememberNavController()
    Scaffold(bottomBar={ NavigationBar { val route=nav.currentBackStackEntryAsState().value?.destination?.route; NavigationBarItem(route=="dashboard", {nav.navigate("dashboard")}, icon={}, label={Text("داشبورد")}); NavigationBarItem(route=="tasks", {nav.navigate("tasks")}, icon={}, label={Text("کارها")}) } }) { pad -> NavHost(nav, startDestination="dashboard", Modifier.padding(pad)) { composable("dashboard"){DashboardScreen()}; composable("tasks"){TasksScreen()} } }
}
