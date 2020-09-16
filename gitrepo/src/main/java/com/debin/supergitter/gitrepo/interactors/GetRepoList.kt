package com.debin.supergitter.gitrepo.interactors

import com.debin.supergitter.gitrepo.data.repository.RoomRepoRepository

class GetRepoList(private val roomRepoRepository: RoomRepoRepository) {
    suspend operator fun invoke(userName : String) = roomRepoRepository.getRepoList(userName)
}