package com.toranj.app.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks ORDER BY completed ASC, createdAt DESC") fun observeAll(): Flow<List<TaskEntity>>
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun upsert(task: TaskEntity): Long
    @Delete suspend fun delete(task: TaskEntity)
    @Query("UPDATE tasks SET completed = :completed WHERE id = :id") suspend fun setCompleted(id: Long, completed: Boolean)
}
