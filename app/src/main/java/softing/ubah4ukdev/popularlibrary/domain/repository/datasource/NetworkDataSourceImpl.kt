package softing.ubah4ukdev.popularlibrary.domain.repository.datasource

import io.reactivex.Maybe
import io.reactivex.Single
import softing.ubah4ukdev.popularlibrary.domain.api.GitHubApi
import softing.ubah4ukdev.popularlibrary.domain.model.GitHubRepository
import softing.ubah4ukdev.popularlibrary.domain.model.GithubUser

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.domain.repository.datasource

Created by Ivan Sheynmaer

2021.08.17
v1.0
 */
class NetworkDataSourceImpl(private val gitHubApi: GitHubApi) : INetworkDataSource {

    override fun fetchUsers(): Single<List<GithubUser>> =
        gitHubApi.fetchUsers()

    override fun fetchUserByLogin(login: String): Maybe<GithubUser> =
        gitHubApi.fetchUserByLogin(login)
            .toMaybe()

    override fun fetchUserRepositories(login: String): Single<List<GitHubRepository>> =
        gitHubApi.fetchUserRepositories(login)

    override fun fetchRepositoryInfo(login: String, repositoryName: String): Single<GitHubRepository> =
        gitHubApi.fetchRepositoryInfo(login, repositoryName)
}