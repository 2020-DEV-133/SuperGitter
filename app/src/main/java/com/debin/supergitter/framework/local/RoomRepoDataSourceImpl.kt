package com.debin.supergitter.framework.local

import android.content.Context
import com.debin.supergitter.gitrepo.data.datasource.RoomRepoDataSource
import com.debin.supergitter.gitrepo.domain.Repositories

class RoomRepoDataSourceImpl(context : Context) : RoomRepoDataSource  {
    override suspend fun addRepos(repo: Repositories) {
        TODO("Not yet implemented")
    }

    override suspend fun getRepoList(userName: String): List<Repositories> {
        TODO("Not yet implemented")
    }
}