package com.debin.supergitter.framework.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RepoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRepos(repo: RepoEntity)

    @Query("SELECT * FROM repo_table WHERE owner_name = :userName")
    suspend fun getReposList(userName:String): List<RepoEntity>

    @Query("SELECT * FROM repo_table WHERE repo_name = :repoName")
    suspend fun getRepoByName(repoName: String) : List<RepoEntity>
}