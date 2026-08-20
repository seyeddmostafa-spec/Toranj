package com.toranj.app.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.toranj.app.data.local.TaskDao
import com.toranj.app.data.local.TaskEntity

@Database(entities = [TaskEntity::class], version = 1, exportSchema = true)
abstract class ToranjDatabase : RoomDatabase() { abstract fun taskDao(): TaskDao }
