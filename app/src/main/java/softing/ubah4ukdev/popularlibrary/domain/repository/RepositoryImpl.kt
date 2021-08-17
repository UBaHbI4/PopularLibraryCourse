package softing.ubah4ukdev.popularlibrary.domain.repository

import io.reactivex.Maybe
import io.reactivex.Observable
import softing.ubah4ukdev.popularlibrary.domain.model.GitHubRepository
import softing.ubah4ukdev.popularlibrary.domain.model.GithubUser
import softing.ubah4ukdev.popularlibrary.domain.repository.datasource.ICacheNetworkDataSource
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
    private val ICache: ICacheNetworkDataSource,
) : IRepository {

    override fun users(): Observable<List<GithubUser>> =
        Observable.merge(
            ICache.users().toObservable(),
            cloud.users().flatMap(ICache::retainUsers).toObservable()
        )

    override fun userById(login: String): Maybe<GithubUser> =
        ICache.userById(login)
            .onErrorResumeNext(
                cloud.userById(login)
            )

    override fun repoInfo(login: String, name: String): Maybe<GitHubRepository> =

        ICache
            .repoInfo(login, name)
            .onErrorResumeNext(
                cloud
                    .repoInfo(login, name)
            )
            .toMaybe()

    /**
     * С помощью map заполняем поле login, которое мы не получаем в результате запроса,
     * но которое нам нужно для сохранения в базу и поиска по нему.
     */
    override fun repoList(login: String): Observable<List<GitHubRepository>> =
        Observable.merge(
            ICache.repoList(login).toObservable(),
            cloud.repoList(login)
                .flattenAsObservable { it }
                .map { repo -> repo.copy(login = login) }
                .toList()
                .flatMap { ICache.retainRepositories(it, login) }.toObservable()
        )
}