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
class NetworkNetworkDataSourceImpl(private val gitHubApi: GitHubApi) : INetworkDataSource {

    override fun users(): Single<List<GithubUser>> =
        gitHubApi.users()

    override fun userById(login: String): Maybe<GithubUser> =
        gitHubApi.userById(login)
            .toMaybe()

    override fun repoList(login: String): Single<List<GitHubRepository>> =
        gitHubApi.repoList(login)

    override fun repoInfo(login: String, name: String): Single<GitHubRepository> =
        gitHubApi.repoInfo(login, name)
}