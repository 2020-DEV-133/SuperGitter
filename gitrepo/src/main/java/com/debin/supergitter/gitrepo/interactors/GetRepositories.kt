package com.debin.supergitter.gitrepo.interactors

import com.debin.supergitter.gitrepo.data.repository.RepoRepository

class GetRepositories(private val repoRepository: RepoRepository) {
    suspend operator fun invoke(userName : String) = repoRepository.getRepoListByUser(userName)
}