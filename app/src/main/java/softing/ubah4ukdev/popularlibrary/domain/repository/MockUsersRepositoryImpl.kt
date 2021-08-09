package softing.ubah4ukdev.popularlibrary.domain.repository

import io.reactivex.Maybe
import io.reactivex.Single
import softing.ubah4ukdev.popularlibrary.domain.model.GithubUser

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.domain.repository

Created by Ivan Sheynmaer

2021.08.05
v1.0
 */
object MockUsersRepositoryImpl : IUsersRepository {
    private val users = listOf(
        GithubUser(userId = 0, login = "Иванов И.И."),
        GithubUser(userId = 1, login = "Петров И.С."),
        GithubUser(userId = 2, login = "Сидоров С.А."),
        GithubUser(userId = 3, login = "Дудкин Б.Б."),
        GithubUser(userId = 4, login = "Сорокин К.А.")
    )

    override fun users(): Single<List<GithubUser>> = Single.just(users)
    //Single.error(Exception("Ошибочка"))

    override fun userById(userId: Int): Maybe<GithubUser> =
        users.firstOrNull { user -> user.userId == userId }
            ?.let { user -> Maybe.just(user) }
            ?: Maybe.error(Exception("Выбран несуществующий пользователь."))
    //?:Maybe.empty()
}