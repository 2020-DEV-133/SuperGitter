package com.debin.supergitter.gitrepo.data.repository

import com.debin.supergitter.gitrepo.data.datasource.UserDataSource

class UserRepository(private val dataSource: UserDataSource) {
    suspend fun searchUser(searchUser : String) = dataSource.searchUserAsync(searchUser).await()
}