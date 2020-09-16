package com.debin.supergitter.gitrepo.interactors

import com.debin.supergitter.gitrepo.data.repository.RoomRepoRepository
import com.debin.supergitter.gitrepo.domain.Repositories

class AddRepositories(private val roomRepoRepository: RoomRepoRepository) {
    suspend operator fun invoke(repo : Repositories) = roomRepoRepository.addRepos(repo)
}