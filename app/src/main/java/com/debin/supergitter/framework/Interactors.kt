package com.debin.supergitter.framework

import com.debin.supergitter.gitrepo.interactors.*

data class Interactors(
    val addRepositories: AddRepositories,
    val addUser: AddUser,
    val deleteUser: DeleteUser,
    val getRepoList: GetRepoList,
    val getRepositories: GetRepositories,
    val getUserList: GetUserList,
    val searchUser: SearchUser
)
