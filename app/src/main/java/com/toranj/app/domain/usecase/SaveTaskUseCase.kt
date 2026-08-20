package com.toranj.app.domain.usecase

import com.toranj.app.domain.model.Task
import com.toranj.app.domain.repository.TaskRepository
import javax.inject.Inject
class SaveTaskUseCase @Inject constructor(private val repository: TaskRepository) { suspend operator fun invoke(task: Task) = repository.save(task) }
