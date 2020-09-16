package com.debin.supergitter.gitrepo.data.datasource

import com.debin.supergitter.gitrepo.domain.User

interface RoomUserDataSource {
    suspend fun addUser(user : User)
    suspend fun getUserList() : List<User>
    suspend fun deleteUser(user : User)
}