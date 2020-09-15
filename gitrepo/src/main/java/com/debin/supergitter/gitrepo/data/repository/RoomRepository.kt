package com.debin.supergitter.gitrepo.data.repository

import com.debin.supergitter.gitrepo.data.datasource.RoomDataSource
import com.debin.supergitter.gitrepo.domain.Repositories
import com.debin.supergitter.gitrepo.domain.User

class RoomRepository(private val roomDataSource: RoomDataSource) {
    suspend fun addUser(user : User) = roomDataSource.addUser(user)
    suspend fun addRepos(repo : Repositories) = roomDataSource.addRepos(repo)
    suspend fun getUserList() = roomDataSource.getUserList()
    suspend fun getRepoList(userName : String) = roomDataSource.getRepoList(userName)
    suspend fun deleteUser(userId : Int) = roomDataSource.deleteUser(userId)
}