package com.toranj.app.presentation.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.toranj.app.presentation.tasks.TasksViewModel

@Composable fun DashboardScreen(vm: TasksViewModel = hiltViewModel()) {
    val state by vm.state.collectAsState()
    Column(Modifier.fillMaxSize().padding(20.dp)) {
        Text("داشبورد ترنج", style=MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(8.dp)); Text("مرکز مدیریت زندگی و برنامه‌ریزی شما")
        Spacer(Modifier.height(20.dp))
        Row(horizontalArrangement=Arrangement.spacedBy(12.dp)) {
            StatCard("کل کارها", state.tasks.size.toString(), Modifier.weight(1f))
            StatCard("انجام‌شده", state.tasks.count{it.completed}.toString(), Modifier.weight(1f))
        }
    }
}
@Composable private fun StatCard(title:String, value:String, modifier:Modifier) { Card(modifier) { Column(Modifier.padding(16.dp)) { Text(title); Spacer(Modifier.height(8.dp)); Text(value, style=MaterialTheme.typography.headlineLarge) } } }
