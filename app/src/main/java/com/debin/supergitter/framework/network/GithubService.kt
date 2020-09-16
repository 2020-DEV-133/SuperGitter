package com.debin.supergitter.framework.network

import com.debin.supergitter.gitrepo.domain.Repositories
import com.debin.supergitter.gitrepo.domain.User
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("users/{username}")
    fun getUsers(@Path("username") type:String): Deferred<User>

    @GET("users/{username}/repos")
    fun getReposByUser(@Path("username") type: String): Deferred<List<Repositories>>
}