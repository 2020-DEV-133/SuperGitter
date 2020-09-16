package com.debin.supergitter.framework.remote

import com.debin.supergitter.framework.network.RetrofitClient
import com.debin.supergitter.gitrepo.data.datasource.UserDataSource
import com.debin.supergitter.gitrepo.domain.User
import kotlinx.coroutines.Deferred

class SearchUserDataSourceImpl : UserDataSource {
    override suspend fun searchUserAsync(searchUser: String): Deferred<User> {
        return RetrofitClient.retrofitInstance.getUsers(searchUser)
    }
}