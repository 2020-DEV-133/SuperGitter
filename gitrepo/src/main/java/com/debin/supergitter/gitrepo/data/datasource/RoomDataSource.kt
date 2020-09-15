package com.debin.supergitter.gitrepo.data.datasource

import com.debin.supergitter.gitrepo.domain.Repositories
import com.debin.supergitter.gitrepo.domain.User

interface RoomDataSource {
    suspend fun addUser(user : User)
    suspend fun addRepos(repo : Repositories)
    suspend fun getUserList() : List<User>
    suspend fun getRepoList(userName : String) : List<Repositories>
    suspend fun deleteUser(userId : Int)
}