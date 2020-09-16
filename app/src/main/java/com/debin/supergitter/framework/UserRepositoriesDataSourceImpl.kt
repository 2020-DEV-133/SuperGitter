package com.debin.supergitter.framework

import com.debin.supergitter.framework.network.RetrofitClient
import com.debin.supergitter.gitrepo.data.datasource.RepositoriesDataSource
import com.debin.supergitter.gitrepo.domain.Repositories
import kotlinx.coroutines.Deferred

class UserRepositoriesDataSourceImpl  : RepositoriesDataSource{
    override suspend fun getRepoListByUserAsync(userName: String): Deferred<List<Repositories>> {
        return RetrofitClient.retrofitInstance.getReposByUser(userName)
    }
}