package com.toranj.app.presentation.tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toranj.app.domain.model.Task
import com.toranj.app.domain.usecase.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

data class TasksUiState(val tasks: List<Task> = emptyList())

@HiltViewModel
class TasksViewModel @Inject constructor(private val observe: ObserveTasksUseCase, private val save: SaveTaskUseCase, private val complete: SetTaskCompletedUseCase) : ViewModel() {
    val state: StateFlow<TasksUiState> = observe().map { TasksUiState(it) }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), TasksUiState())
    fun add(title: String) { viewModelScope.launch { save(Task(title = title.trim())) } }
    fun toggle(task: Task) { viewModelScope.launch { complete(task.id, !task.completed) } }
}
