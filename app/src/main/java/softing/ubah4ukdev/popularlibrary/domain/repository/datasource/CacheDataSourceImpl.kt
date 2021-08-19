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
class CacheDataSourceImpl(private val gitHubStorage: GitHubStorage) :
    ICacheDataSource {

    override fun retainUsers(users: List<GithubUser>): Single<List<GithubUser>> =
        gitHubStorage
            .gitHubUserDao()
            .retainUsers(users)
            .andThen(fetchUsers())

    override fun retainUser(user: GithubUser): Single<GithubUser> =
        gitHubStorage
            .gitHubUserDao()
            .retainUsers(user)
            .andThen(fetchUserByLogin(user.login))
            .toSingle()

    override fun retainRepositories(
        repositories: List<GitHubRepository>,
        login: String
    ): Single<List<GitHubRepository>> =
        gitHubStorage
            .gitHubUserDao()
            .retainRepositories(repositories)
            .andThen(fetchUserRepositories(login))

    override fun retainRepository(
        repository: GitHubRepository,
        login: String,
        repositoryName: String
    ): Single<GitHubRepository> =
        gitHubStorage
            .gitHubUserDao()
            .retainRepository(repository)
            .andThen(fetchRepositoryInfo(login, repositoryName))

    override fun fetchUsers(): Single<List<GithubUser>> =
        gitHubStorage
            .gitHubUserDao()
            .fetchUsers()

    override fun fetchUserByLogin(login: String): Maybe<GithubUser> =
        gitHubStorage
            .gitHubUserDao()
            .fetchUserByLogin(login)
            .toMaybe()


    override fun fetchUserRepositories(login: String): Single<List<GitHubRepository>> =
        gitHubStorage
            .gitHubUserDao()
            .fetchUserRepositories(login)

    override fun fetchRepositoryInfo(login: String, repositoryName: String): Single<GitHubRepository> =
        gitHubStorage
            .gitHubUserDao()
            .fetchRepositoryInfo(login, repositoryName)
}