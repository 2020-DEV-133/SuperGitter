package com.debin.supergitter.gitrepo.interactors

import com.debin.supergitter.gitrepo.data.repository.RoomRepository

class GetRepoList(private val roomRepository: RoomRepository) {
    suspend operator fun invoke(userName : String) = roomRepository.getRepoList(userName)
}