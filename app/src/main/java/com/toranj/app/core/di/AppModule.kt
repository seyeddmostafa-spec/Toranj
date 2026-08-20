package com.toranj.app.core.di

import android.content.Context
import androidx.room.Room
import com.toranj.app.core.database.ToranjDatabase
import com.toranj.app.data.local.TaskDao
import com.toranj.app.data.repository.TaskRepositoryImpl
import com.toranj.app.domain.repository.TaskRepository
import dagger.Module
import dagger.Provides
import dagger.Binds
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides @Singleton fun provideDatabase(@ApplicationContext context: Context): ToranjDatabase = Room.databaseBuilder(context, ToranjDatabase::class.java, "toranj.db").build()
    @Provides fun provideTaskDao(db: ToranjDatabase): TaskDao = db.taskDao()
}

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule { @Binds abstract fun bindTaskRepository(impl: TaskRepositoryImpl): TaskRepository }
