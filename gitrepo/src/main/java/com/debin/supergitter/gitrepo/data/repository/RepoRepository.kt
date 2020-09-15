package com.debin.supergitter.gitrepo.data.repository

import com.debin.supergitter.gitrepo.data.datasource.RepositoriesDataSource
import com.debin.supergitter.gitrepo.domain.Repositories

class RepoRepository(private val dataSource: RepositoriesDataSource) {
    suspend fun getRepoListByUser(userName : String) = dataSource.getRepoListByUser(userName)
}