package com.toranj.app.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.toranj.app.domain.model.Task

@Entity(tableName = "tasks")
data class TaskEntity(@PrimaryKey(autoGenerate = true) val id: Long = 0, val title: String, val category: String, val completed: Boolean, val createdAt: Long) {
    fun toDomain() = Task(id, title, category, completed, createdAt)
    companion object { fun fromDomain(t: Task) = TaskEntity(t.id, t.title, t.category, t.completed, t.createdAt) }
}
