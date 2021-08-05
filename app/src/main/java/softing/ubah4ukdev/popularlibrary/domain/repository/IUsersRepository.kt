package softing.ubah4ukdev.popularlibrary.domain.repository

import softing.ubah4ukdev.popularlibrary.domain.model.GithubUser

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.domain.repository

Created by Ivan Sheynmaer

2021.08.05
v1.0
 */
interface IUsersRepository {

    //Список пользователей
    fun users(): List<GithubUser>
}