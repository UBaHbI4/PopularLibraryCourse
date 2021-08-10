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
interface IUsersRepository {

    //Список пользователей
    fun users(): Single<List<GithubUser>>

    //Получить пользователя по userID
    fun userById(userId: Int): Maybe<GithubUser>
}