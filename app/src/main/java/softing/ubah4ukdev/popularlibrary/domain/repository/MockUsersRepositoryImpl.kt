package softing.ubah4ukdev.popularlibrary.domain.repository

import io.reactivex.Maybe
import io.reactivex.Single
import softing.ubah4ukdev.popularlibrary.domain.model.GitHubRepository
import softing.ubah4ukdev.popularlibrary.domain.model.GithubUser

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.domain.repository

Created by Ivan Sheynmaer

2021.08.05
v1.0
 */

/**
 * Фиксированный репозиторий для отладки
 */
class MockUsersRepositoryImpl : IUsersRepository {

    private val users = listOf(
        GithubUser(userId = "0", login = "Иванов И.И.", "", "0"),
        GithubUser(userId = "1", login = "Петров И.С.", "", "1"),
        GithubUser(userId = "2", login = "Сидоров С.А.", "", "2"),
        GithubUser(userId = "3", login = "Дудкин Б.Б.", "", "3"),
        GithubUser(userId = "4", login = "Сорокин К.А.", "", "4")
    )

    private val repositories = listOf(
        GitHubRepository(
            id = "1",
            login = "Иванов И.И.",
            "test",
            "descr1",
            "Ru",
            12,
            "master",
            "",
            1
        ),
        GitHubRepository(
            id = "2",
            login = "Иванов И.И.",
            "test2",
            "descr2",
            "Ru",
            11,
            "master",
            "",
            3
        ),
        GitHubRepository(
            id = "3",
            login = "Иванов И.И.",
            "test3",
            "descr3",
            "Ru",
            10,
            "master",
            "",
            6
        ),
        GitHubRepository(
            id = "4",
            login = "Петров И.С.",
            "test4",
            "descr4",
            "Ru",
            9,
            "master",
            "",
            7
        ),
        GitHubRepository(
            id = "5",
            login = "Сидоров С.А.",
            "test5",
            "descr5",
            "Ru",
            5,
            "master",
            "",
            2
        ),
        GitHubRepository(
            id = "6",
            login = "Дудкин Б.Б.",
            "test6",
            "descr6",
            "Ru",
            7,
            "master",
            "",
            6
        ),
        GitHubRepository(
            id = "7",
            login = "Сорокин К.А.",
            "test7",
            "descr7",
            "Ru",
            8,
            "master",
            "",
            12
        ),
    )

    override fun users(): Single<List<GithubUser>> = Single.just(users)

    override fun userById(login: String): Maybe<GithubUser> =
        users.firstOrNull { user -> user.login.equals(login) }
            ?.let { user -> Maybe.just(user) }
            ?: Maybe.error(Exception("Выбран несуществующий пользователь."))

    override fun repoList(login: String): Single<List<GitHubRepository>> =
        Single.just(repositories.filter { repository -> repository.login.equals(login) })
}