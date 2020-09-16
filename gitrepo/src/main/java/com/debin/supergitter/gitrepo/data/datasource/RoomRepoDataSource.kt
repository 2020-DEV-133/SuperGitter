package com.debin.supergitter.gitrepo.data.datasource

import com.debin.supergitter.gitrepo.domain.Repositories

interface RoomRepoDataSource {
    suspend fun addRepos(repo : Repositories)
    suspend fun getRepoList(userName : String) : List<Repositories>
}