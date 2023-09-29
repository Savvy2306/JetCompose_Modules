package com.sarvesh.jetcompose_modules.ToDo.di

import android.app.Application
import androidx.room.Room
import com.sarvesh.jetcompose_modules.ToDo.ToDoDatabase
import com.sarvesh.jetcompose_modules.ToDo.dao.TodoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(application: Application): ToDoDatabase =
        Room.databaseBuilder(application, ToDoDatabase::class.java,"ToDoDatabase")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun providesDao(db: ToDoDatabase): TodoDao = db.getTodoDao()


}