package com.debin.supergitter.gitrepo.domain

data class User(
    val avatar_url: String?,
    val id: Int,
    val name: String,
    val public_repos: Int?,
)