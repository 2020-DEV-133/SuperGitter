package com.debin.supergitter.framework.local

import android.content.Context
import com.debin.supergitter.framework.db.SuperGitterDatabase
import com.debin.supergitter.framework.db.UserEntity
import com.debin.supergitter.gitrepo.data.datasource.RoomUserDataSource
import com.debin.supergitter.gitrepo.domain.User

class RoomUserDataSourceImpl(context: Context)  : RoomUserDataSource {

    private val userDao = SuperGitterDatabase.getInstance(context).userDao()

    override suspend fun addUser(user: User) =
        userDao.insertUser(UserEntity(user.id, user.name, user.avatar_url, user.public_repos))

    override suspend fun getUserList(): List<User> =
         userDao.getUsersList().map {
            User(it.avatar_url,it.id,it.name,it.repositories)

    }

    override suspend fun deleteUser(user: User) = userDao.deleteUser(
        UserEntity(user.id,user.name, user.avatar_url, user.public_repos))
}