package com.toranj.app.domain.repository

import com.toranj.app.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository { fun observeTasks(): Flow<List<Task>>; suspend fun save(task: Task); suspend fun setCompleted(id: Long, completed: Boolean); suspend fun delete(task: Task) }
