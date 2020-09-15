package com.debin.supergitter.gitrepo.interactors

import com.debin.supergitter.gitrepo.data.repository.RoomRepository
import com.debin.supergitter.gitrepo.data.repository.UserRepository
import com.debin.supergitter.gitrepo.domain.User

class AddUser(private val roomRepository: RoomRepository) {
    suspend operator fun invoke(user : User) = roomRepository.addUser(user)
}