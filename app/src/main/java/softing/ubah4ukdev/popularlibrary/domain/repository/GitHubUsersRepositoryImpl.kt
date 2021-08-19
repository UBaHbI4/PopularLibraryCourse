package softing.ubah4ukdev.popularlibrary.domain.repository

import io.reactivex.Maybe
import io.reactivex.Single
import softing.ubah4ukdev.popularlibrary.domain.api.GitHubApi
import softing.ubah4ukdev.popularlibrary.domain.model.GitHubRepository
import softing.ubah4ukdev.popularlibrary.domain.model.GithubUser

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.domain.repository

Created by Ivan Sheynmaer

2021.08.16
v1.0
 */
class GitHubUsersRepositoryImpl(
    private val apiRepository: GitHubApi
) : IUsersRepository {
    override fun users(): Single<List<GithubUser>> =
        apiRepository.fetchUsers()

    override fun userById(login: String): Maybe<GithubUser> =
        apiRepository.fetchUserByLogin(login)
            .toMaybe()

    override fun repoList(login: String): Single<List<GitHubRepository>> =
        apiRepository.fetchUserRepositoriesByLogin(login)
}