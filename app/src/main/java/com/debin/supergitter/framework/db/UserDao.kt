package com.debin.supergitter.framework.db

import androidx.room.*
import com.debin.supergitter.gitrepo.domain.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: UserEntity)

    @Query("SELECT * FROM user_table ORDER BY repositories ASC")
    fun getUsersList(): List<UserEntity>

    @Delete
    fun deleteUserById(user: UserEntity)
}