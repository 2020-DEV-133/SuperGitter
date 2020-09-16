package com.debin.supergitter.framework.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RepoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRepos(repo: RepoEntity)

    @Query("SELECT * FROM repo_table WHERE owner_name = :userName")
    fun getReposList(userName:String): List<RepoEntity>
}