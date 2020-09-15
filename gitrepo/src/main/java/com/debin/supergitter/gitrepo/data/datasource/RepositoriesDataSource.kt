package com.debin.supergitter.gitrepo.data.datasource

import com.debin.supergitter.gitrepo.domain.Repositories

interface RepositoriesDataSource {
    suspend fun getRepoListByUser(userName : String) : List<Repositories>
}