package com.debin.supergitter.gitrepo.interactors

import com.debin.supergitter.gitrepo.data.repository.RoomRepository

class DeleteUser(private val roomRepository: RoomRepository) {
    suspend operator fun invoke(userId : Int) = roomRepository.deleteUser(userId)
}