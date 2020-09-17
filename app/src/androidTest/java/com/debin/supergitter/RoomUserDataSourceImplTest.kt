package com.debin.supergitter

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.debin.supergitter.framework.db.SuperGitterDatabase
import com.debin.supergitter.framework.db.UserDao
import com.debin.supergitter.framework.db.UserEntity
import com.debin.supergitter.framework.local.RoomUserDataSourceImpl
import com.debin.supergitter.gitrepo.data.datasource.RoomUserDataSource
import com.debin.supergitter.gitrepo.domain.User
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.*

class RoomUserDataSourceImplTest {
    private lateinit var roomUserDataSourceImpl: RoomUserDataSourceImpl
    private lateinit var database: SuperGitterDatabase

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            SuperGitterDatabase::class.java)
            .allowMainThreadQueries()
            .build()

        roomUserDataSourceImpl = RoomUserDataSourceImpl(ApplicationProvider.getApplicationContext())

    }

    @After
    fun cleanUp() {
        database.close()
    }

    @Test
     fun addUser_RetriveUser() =  runBlocking {
        val user = User("avartharUrl", 1, "Debin", 25)
        roomUserDataSourceImpl.addUser(user)
        val userList = roomUserDataSourceImpl.getUserList()
        MatcherAssert.assertThat(userList.get(0).name, CoreMatchers.`is`("Debin"))
    }


}