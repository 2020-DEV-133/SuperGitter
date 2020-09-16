package com.debin.supergitter.gitrepo.data.repository

import com.debin.supergitter.gitrepo.data.datasource.RoomUserDataSource
import com.debin.supergitter.gitrepo.domain.User

class RoomUserRepository(private val roomUserDataSource: RoomUserDataSource) {
    suspend fun addUser(user : User) = roomUserDataSource.addUser(user)
    suspend fun getUserList() = roomUserDataSource.getUserList()
    suspend fun deleteUser(user : User) = roomUserDataSource.deleteUser(user)
}