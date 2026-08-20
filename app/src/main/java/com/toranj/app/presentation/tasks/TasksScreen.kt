package com.toranj.app.presentation.tasks

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable fun TasksScreen(vm: TasksViewModel = hiltViewModel()) {
    val state by vm.state.collectAsState()
    var title by remember { mutableStateOf("") }
    Column(Modifier.fillMaxSize().padding(20.dp)) {
        Text("کارها", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))
        Row(Modifier.fillMaxWidth()) { OutlinedTextField(title, { title = it }, Modifier.weight(1f), label={Text("کار جدید")}); Spacer(Modifier.width(8.dp)); Button(onClick={ if(title.isNotBlank()){vm.add(title); title=""} }) { Text("افزودن") } }
        Spacer(Modifier.height(16.dp))
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) { items(state.tasks, key={it.id}) { task -> Card(Modifier.fillMaxWidth()) { Row(Modifier.padding(14.dp), horizontalArrangement=Arrangement.spacedBy(10.dp)) { Checkbox(task.completed, {vm.toggle(task)}); Column { Text(task.title); Text(task.category, style=MaterialTheme.typography.bodySmall) } } } } }
    }
}
