package com.debin.supergitter.gitrepo.data.repository

import com.debin.supergitter.gitrepo.data.datasource.UserDataSource
import com.debin.supergitter.gitrepo.domain.User

class UserRepository(private val dataSource: UserDataSource) {
    suspend fun searchUser(searchUser : String) = dataSource.searchUser(searchUser)
}