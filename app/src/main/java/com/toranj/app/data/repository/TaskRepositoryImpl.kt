package com.toranj.app.data.repository

import com.toranj.app.data.local.TaskDao
import com.toranj.app.data.local.TaskEntity
import com.toranj.app.domain.model.Task
import com.toranj.app.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(private val dao: TaskDao) : TaskRepository {
    override fun observeTasks(): Flow<List<Task>> = dao.observeAll().map { list -> list.map(TaskEntity::toDomain) }
    override suspend fun save(task: Task) { dao.upsert(TaskEntity.fromDomain(task)) }
    override suspend fun setCompleted(id: Long, completed: Boolean) { dao.setCompleted(id, completed) }
    override suspend fun delete(task: Task) { dao.delete(TaskEntity.fromDomain(task)) }
}
