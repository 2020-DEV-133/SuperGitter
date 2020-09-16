package com.debin.supergitter.gitrepo.interactors

import com.debin.supergitter.gitrepo.data.repository.RoomUserRepository

class GetUserList(private val roomUserRepository: RoomUserRepository) {
    suspend operator fun invoke() = roomUserRepository.getUserList()
}