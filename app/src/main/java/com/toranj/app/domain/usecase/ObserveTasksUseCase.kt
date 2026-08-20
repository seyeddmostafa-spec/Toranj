package com.toranj.app.domain.usecase

import com.toranj.app.domain.repository.TaskRepository
import javax.inject.Inject
class ObserveTasksUseCase @Inject constructor(private val repository: TaskRepository) { operator fun invoke() = repository.observeTasks() }
