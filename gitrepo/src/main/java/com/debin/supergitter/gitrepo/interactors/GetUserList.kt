package com.debin.supergitter.gitrepo.interactors

import com.debin.supergitter.gitrepo.data.repository.RoomRepository

class GetUserList(private val roomRepository: RoomRepository) {
    suspend operator fun invoke() = roomRepository.getUserList()
}