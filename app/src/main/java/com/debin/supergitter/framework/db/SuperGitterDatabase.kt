package com.debin.supergitter.framework.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [UserEntity::class, RepoEntity::class],
    version = 1,
    exportSchema = false
)
abstract class SuperGitterDatabase : RoomDatabase() {

    companion object {
        private const val DATABASE_NAME = "supergitter.db"
        private var instance : SuperGitterDatabase? = null

        private fun create(context: Context): SuperGitterDatabase =
            Room.databaseBuilder(context, SuperGitterDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()

        fun getInstance(context: Context): SuperGitterDatabase =
            (instance ?: create(context)).also { instance = it }
    }

    abstract fun userDao() : UserDao

    abstract fun repoDao() : RepoDao
}