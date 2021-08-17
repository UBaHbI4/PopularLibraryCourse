package softing.ubah4ukdev.popularlibrary.domain.repository.datasource

import io.reactivex.Maybe
import io.reactivex.Single
import softing.ubah4ukdev.popularlibrary.domain.model.GitHubRepository
import softing.ubah4ukdev.popularlibrary.domain.model.GithubUser
import softing.ubah4ukdev.popularlibrary.domain.storage.GitHubStorage

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.domain.repository.datasource

Created by Ivan Sheynmaer

2021.08.17
v1.0
 */
class CacheNetworkDataSourceImpl(private val gitHubStorage: GitHubStorage) :
    ICacheNetworkDataSource {

    override fun retainUsers(users: List<GithubUser>): Single<List<GithubUser>> =
        gitHubStorage
            .gitHubUserDao()
            .retainUsers(users)
            .andThen(users())

    override fun retainUser(user: GithubUser): Single<GithubUser> =
        gitHubStorage
            .gitHubUserDao()
            .retainUsers(user)
            .andThen(userById(user.login))
            .toSingle()

    override fun retainRepositories(
        repos: List<GitHubRepository>,
        login: String
    ): Single<List<GitHubRepository>> =
        gitHubStorage
            .gitHubUserDao()
            .retainRepositories(repos)
            .andThen(repoList(login))

    override fun retainRepository(
        repo: GitHubRepository,
        login: String,
        name: String
    ): Single<GitHubRepository> =
        gitHubStorage
            .gitHubUserDao()
            .retainRepository(repo)
            .andThen(repoInfo(login, name))

    override fun users(): Single<List<GithubUser>> =
        gitHubStorage
            .gitHubUserDao()
            .users()

    override fun userById(login: String): Maybe<GithubUser> =
        gitHubStorage
            .gitHubUserDao()
            .userByLogin(login)
            .toMaybe()


    override fun repoList(login: String): Single<List<GitHubRepository>> =
        gitHubStorage
            .gitHubUserDao()
            .repoList(login)

    override fun repoInfo(login: String, name: String): Single<GitHubRepository> =
        gitHubStorage
            .gitHubUserDao()
            .repoInfo(login, name)
}