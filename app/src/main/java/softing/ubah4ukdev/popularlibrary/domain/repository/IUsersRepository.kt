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

    /**
     * Получить список пользователей
     * @return Список пользователей List of GithubUser
     */
    fun users(): Single<List<GithubUser>>

    /**
     * Получить пользователя по userID
     * @param userId Id пользователя
     * @return GithubUser
     */
    fun userById(userId: String): Maybe<GithubUser>
}