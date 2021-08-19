package softing.ubah4ukdev.popularlibrary.domain.repository

import io.reactivex.Maybe
import io.reactivex.Observable
import softing.ubah4ukdev.popularlibrary.domain.model.GitHubRepository
import softing.ubah4ukdev.popularlibrary.domain.model.GithubUser
import softing.ubah4ukdev.popularlibrary.domain.repository.datasource.ICacheDataSource
import softing.ubah4ukdev.popularlibrary.domain.repository.datasource.INetworkDataSource

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.domain.repository

Created by Ivan Sheynmaer

2021.08.16
v1.0
 */
class RepositoryImpl(
    private val cloud: INetworkDataSource,
    private val cache: ICacheDataSource,
) : IRepository {

    override fun fetchUsers(): Observable<List<GithubUser>> =
        Observable.merge(
            cache.fetchUsers().toObservable(),
            cloud.fetchUsers().flatMap(cache::retainUsers).toObservable()
        )

    override fun fetchUserByLogin(login: String): Maybe<GithubUser> =
        cache.fetchUserByLogin(login)
            .onErrorResumeNext(
                cloud.fetchUserByLogin(login)
            )

    override fun fetchRepositoryInfo(
        login: String,
        repositoryName: String
    ): Maybe<GitHubRepository> =

        cache
            .fetchRepositoryInfo(login, repositoryName)
            .onErrorResumeNext(
                cloud
                    .fetchRepositoryInfo(login, repositoryName)
            )
            .toMaybe()

    /**
     * С помощью map заполняем поле login, которое мы не получаем в результате запроса,
     * но которое нам нужно для сохранения в базу и поиска по нему.
     */
    override fun fetchUserRepositoriesByLogin(login: String): Observable<List<GitHubRepository>> =
        Observable.merge(
            cache.fetchUserRepositories(login).toObservable(),
            cloud.fetchUserRepositories(login)
                .flattenAsObservable { it }
                .map { repo -> repo.copy(login = login) }
                .toList()
                .flatMap { cache.retainRepositories(it, login) }.toObservable()
        )
}