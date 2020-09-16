package com.debin.supergitter.gitrepo.data.repository

import com.debin.supergitter.gitrepo.data.datasource.RepositoriesDataSource

class RepoRepository(private val dataSource: RepositoriesDataSource) {
    suspend fun getRepoListByUser(userName : String) = dataSource.getRepoListByUserAsync(userName).await()
}