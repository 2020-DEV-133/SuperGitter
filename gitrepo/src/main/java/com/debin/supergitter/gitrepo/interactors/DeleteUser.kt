package com.debin.supergitter.gitrepo.interactors

import com.debin.supergitter.gitrepo.data.repository.RoomUserRepository
import com.debin.supergitter.gitrepo.domain.User

class DeleteUser(private val roomUserRepository: RoomUserRepository) {
    suspend operator fun invoke(user : User) = roomUserRepository.deleteUser(user)
}