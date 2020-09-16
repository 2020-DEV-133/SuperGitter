package com.debin.supergitter.gitrepo.data.datasource

import com.debin.supergitter.gitrepo.domain.User
import kotlinx.coroutines.Deferred

interface UserDataSource {
    suspend fun searchUserAsync(searchUser : String) : Deferred<User>
}