package softing.ubah4ukdev.popularlibrary.domain.repository

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
        GithubUser("Иванов И.И."),
        GithubUser("Петров И.С."),
        GithubUser("Сидоров С.А."),
        GithubUser("Дудкин Б.Б."),
        GithubUser("Сорокин К.А.")
    )

    override fun users(): List<GithubUser> {
        return users
    }
}