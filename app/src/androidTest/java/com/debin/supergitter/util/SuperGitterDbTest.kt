package com.debin.supergitter.util


import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.debin.supergitter.framework.db.SuperGitterDatabase
import com.debin.supergitter.gitrepo.data.datasource.RoomUserDataSource
import org.junit.After
import org.junit.Before


abstract class SuperGitterDbTest {
     lateinit var database : SuperGitterDatabase


    @Before
    fun initDb() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            SuperGitterDatabase::class.java).build()
    }
    @After
    fun closeDb() = database.close()
}