package com.debin.supergitter


import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.debin.supergitter.framework.db.SuperGitterDatabase
import com.debin.supergitter.framework.db.UserEntity
import com.debin.supergitter.util.SuperGitterDbTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@ExperimentalCoroutinesApi

class UserDaoTest : SuperGitterDbTest() {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()


    @Test
    fun insertUserGetByName() = runBlocking {
        // GIVEN - insert a user
        val userEntity = UserEntity(1, "Debin", "url", 5)
        database.userDao().insertUser(userEntity)

        // WHEN - Get the user by name from the database
        val loaded = database.userDao().getUserByName(userEntity.name)

        // THEN - The loaded data contains the expected values
        MatcherAssert.assertThat<UserEntity>(loaded.get(0) as UserEntity, CoreMatchers.notNullValue())
        MatcherAssert.assertThat(loaded.get(0).id, `is` (userEntity.id))
        MatcherAssert.assertThat(loaded.get(0).name, `is` (userEntity.name))
        MatcherAssert.assertThat(loaded.get(0).avatar_url, `is` (userEntity.avatar_url))
        MatcherAssert.assertThat(loaded.get(0).repositories, `is` (userEntity.repositories))
    }

    @Test
    fun insertUserAndRetrieveListUsers() = runBlocking {
        // GIVEN - insert a user
        val userEntity = UserEntity(1, "Debin", "url", 5)
        database.userDao().insertUser(userEntity)
        val userEntity1 = UserEntity(2, "Tom", "url", 7)
        database.userDao().insertUser(userEntity1)
        // WHEN - Get the user by name from the database
        val loaded = database.userDao().getUsersList()

        // THEN - The loaded data contains the expected values
        MatcherAssert.assertThat<UserEntity>(loaded.get(0) as UserEntity, CoreMatchers.notNullValue())
        MatcherAssert.assertThat(loaded.get(0).id, `is` (userEntity.id))
        MatcherAssert.assertThat(loaded.get(0).name, `is` (userEntity.name))
        MatcherAssert.assertThat(loaded.get(0).avatar_url, `is` (userEntity.avatar_url))
        MatcherAssert.assertThat(loaded.get(0).repositories, `is` (userEntity.repositories))

        MatcherAssert.assertThat<UserEntity>(loaded.get(1) as UserEntity, CoreMatchers.notNullValue())
        MatcherAssert.assertThat(loaded.get(1).id, `is` (userEntity1.id))
        MatcherAssert.assertThat(loaded.get(1).name, `is` (userEntity1.name))
        MatcherAssert.assertThat(loaded.get(1).avatar_url, `is` (userEntity1.avatar_url))
        MatcherAssert.assertThat(loaded.get(1).repositories, `is` (userEntity1.repositories))
    }


}