package com.debin.supergitter.gitrepo.interactors

import com.debin.supergitter.gitrepo.data.repository.UserRepository

class SearchUser(private val userRepository: UserRepository) {
    suspend operator fun invoke(searchUser : String) = userRepository.searchUser(searchUser)
}