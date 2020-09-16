package com.debin.supergitter

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.debin.supergitter.framework.db.RepoEntity
import com.debin.supergitter.framework.db.SuperGitterDatabase
import com.debin.supergitter.framework.db.UserEntity
import com.debin.supergitter.util.SuperGitterDbTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@ExperimentalCoroutinesApi
class RepoDaoTest : SuperGitterDbTest() {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun insertRepoGetByName() = runBlockingTest {
        // GIVEN - insert a repo
        val repoEntity = RepoEntity(1, "SupperGitter", "Debin",
            2, false, "today")
        database.repoDao().insertRepos(repoEntity)

        // WHEN - Get the repo by name from the database
        val loaded = database.repoDao().getRepoByName(repoEntity.name)

        // THEN - The loaded data contains the expected values
        MatcherAssert.assertThat<RepoEntity>(loaded.get(0) as RepoEntity, CoreMatchers.notNullValue())
        MatcherAssert.assertThat(loaded.get(0).id, CoreMatchers.`is` (repoEntity.id))
        MatcherAssert.assertThat(loaded.get(0).name, CoreMatchers.`is` (repoEntity.name))
    }

    @Test
    fun insertRepoAndRetrieveListRepos() = runBlockingTest {
        // GIVEN - insert a repo
        val repoEntity = RepoEntity(1, "SupperGitter", "Debin",
            2, false, "today")
        database.repoDao().insertRepos(repoEntity)

        // WHEN - Get the repo by name from the database
        val loaded = database.repoDao().getReposList(repoEntity.owner_name)

        // THEN - The loaded data contains the expected values
        MatcherAssert.assertThat<RepoEntity>(loaded.get(0) as RepoEntity, CoreMatchers.notNullValue())
        MatcherAssert.assertThat(loaded.get(0).id, CoreMatchers.`is` (repoEntity.id))
        MatcherAssert.assertThat(loaded.get(0).name, CoreMatchers.`is` (repoEntity.name))
        MatcherAssert.assertThat(loaded.get(0).owner_name, CoreMatchers.`is` (repoEntity.owner_name))
        MatcherAssert.assertThat(loaded.get(0).isPrivate, CoreMatchers.`is` (repoEntity.isPrivate))
    }
}