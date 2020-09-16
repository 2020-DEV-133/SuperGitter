package com.debin.supergitter.framework.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.debin.supergitter.gitrepo.domain.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Query("SELECT * FROM user_table Where name = :userName")
    suspend fun getUserByName(userName : String) : List<UserEntity>

    @Query("SELECT * FROM user_table ORDER BY repositories ASC")
    suspend fun getUsersList(): List<UserEntity>

    @Delete
    suspend fun deleteUser(user: UserEntity)

    @Query("DELETE FROM user_table WHERE id = :userId")
    suspend fun deleteUserById(userId: Int)
}