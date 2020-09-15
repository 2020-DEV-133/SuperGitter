package com.debin.supergitter.gitrepo.data.datasource

import com.debin.supergitter.gitrepo.domain.User

interface UserDataSource {
    suspend fun searchUser(searchUser : String) : List<User>
}