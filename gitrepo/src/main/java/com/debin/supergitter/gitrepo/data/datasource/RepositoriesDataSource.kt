package com.debin.supergitter.gitrepo.data.datasource

import com.debin.supergitter.gitrepo.domain.Repositories
import kotlinx.coroutines.Deferred

interface RepositoriesDataSource {
    suspend fun getRepoListByUserAsync(userName : String) : Deferred<List<Repositories>>
}