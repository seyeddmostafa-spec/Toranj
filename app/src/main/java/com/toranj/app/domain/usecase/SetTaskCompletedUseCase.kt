package com.toranj.app.domain.usecase

import com.toranj.app.domain.repository.TaskRepository
import javax.inject.Inject
class SetTaskCompletedUseCase @Inject constructor(private val repository: TaskRepository) { suspend operator fun invoke(id: Long, completed: Boolean) = repository.setCompleted(id, completed) }
