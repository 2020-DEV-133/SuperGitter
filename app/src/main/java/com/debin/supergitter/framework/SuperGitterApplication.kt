package com.debin.supergitter.framework

import android.app.Application
import com.debin.supergitter.framework.local.RoomRepoDataSourceImpl
import com.debin.supergitter.framework.local.RoomUserDataSourceImpl
import com.debin.supergitter.framework.remote.SearchUserDataSourceImpl
import com.debin.supergitter.framework.remote.UserRepositoriesDataSourceImpl
import com.debin.supergitter.gitrepo.data.datasource.RepositoriesDataSource
import com.debin.supergitter.gitrepo.data.repository.RepoRepository
import com.debin.supergitter.gitrepo.data.repository.RoomRepoRepository
import com.debin.supergitter.gitrepo.data.repository.RoomUserRepository
import com.debin.supergitter.gitrepo.data.repository.UserRepository
import com.debin.supergitter.gitrepo.interactors.*

class SuperGitterApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val repoRepository = RepoRepository(UserRepositoriesDataSourceImpl())
        val userRepository = UserRepository(SearchUserDataSourceImpl())
        val roomUserRepository = RoomUserRepository(RoomUserDataSourceImpl(this))
        val roomRepoRepository = RoomRepoRepository(RoomRepoDataSourceImpl(this))

        SuperGitterViewModelFactory.inject(this, Interactors(
            AddRepositories(roomRepoRepository),
            AddUser(roomUserRepository),
            DeleteUser(roomUserRepository),
            GetRepoList(roomRepoRepository),
            GetRepositories(repoRepository),
            GetUserList(roomUserRepository),
            SearchUser(userRepository)))
    }
}