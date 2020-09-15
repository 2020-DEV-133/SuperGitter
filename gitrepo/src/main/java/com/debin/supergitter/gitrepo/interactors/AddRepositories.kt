package com.debin.supergitter.gitrepo.interactors

import com.debin.supergitter.gitrepo.data.repository.RepoRepository
import com.debin.supergitter.gitrepo.data.repository.RoomRepository
import com.debin.supergitter.gitrepo.domain.Repositories

class AddRepositories(private val roomRepository: RoomRepository) {
    suspend operator fun invoke(repo : Repositories) = roomRepository.addRepos(repo)
}