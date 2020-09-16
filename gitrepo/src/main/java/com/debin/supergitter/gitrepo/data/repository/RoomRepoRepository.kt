package com.debin.supergitter.gitrepo.data.repository

import com.debin.supergitter.gitrepo.data.datasource.RoomRepoDataSource
import com.debin.supergitter.gitrepo.domain.Repositories

class RoomRepoRepository(private val roomRepoDataSource: RoomRepoDataSource) {
    suspend fun addRepos(repo : Repositories) = roomRepoDataSource.addRepos(repo)
    suspend fun getRepoList(userName : String) = roomRepoDataSource.getRepoList(userName)
}