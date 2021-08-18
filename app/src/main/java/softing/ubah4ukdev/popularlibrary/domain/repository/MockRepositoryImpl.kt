package softing.ubah4ukdev.popularlibrary.domain.repository

import io.reactivex.Maybe
import io.reactivex.Observable
import softing.ubah4ukdev.popularlibrary.domain.model.GitHubRepository
import softing.ubah4ukdev.popularlibrary.domain.model.GithubUser

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.domain.repository

Created by Ivan Sheynmaer

2021.08.05
v1.0
Фиксированный репозиторий для отладки
 */
class MockRepositoryImpl : IRepository {

    private val users = listOf(
        GithubUser(userId = "0", login = "Иванов И.И.", "", ""),
        GithubUser(userId = "1", login = "Петров И.С.", "", ""),
        GithubUser(userId = "2", login = "Сидоров С.А.", "", ""),
        GithubUser(userId = "3", login = "Дудкин Б.Б.", "", ""),
        GithubUser(userId = "4", login = "Сорокин К.А.", "", "")
    )

    override fun users(): Observable<List<GithubUser>> = Observable.just(users)

    override fun userById(login: String): Maybe<GithubUser> =
        users.firstOrNull { user -> user.userId.equals(login) }
            ?.let { user -> Maybe.just(user) }
            ?: Maybe.error(Exception("Выбран несуществующий пользователь."))

    override fun repoInfo(login: String, name: String): Maybe<GitHubRepository> {
        TODO("Not yet implemented")
    }

    override fun repoList(login: String): Observable<List<GitHubRepository>> {
        TODO("Not yet implemented")
    }
}