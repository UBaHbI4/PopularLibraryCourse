package softing.ubah4ukdev.popularlibrary.domain.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import softing.ubah4ukdev.popularlibrary.domain.model.GithubUser

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.domain.api

Created by Ivan Sheynmaer

2021.08.16
v1.0
 */
interface GitHubApi {

    /**
     * Получить список пользователей
     * @param since
     * @return Список пользователей List of GithubUser
     */
    @GET("/users")
    fun users(@Query("since") since: Int? = null): Single<List<GithubUser>>

    /**
     * Получить пользователя по логину
     * @param login Логин пользователя
     * @return GithubUser
     */
    @GET("/users/{username}")
    fun userById(@Path("username") login: String): Single<GithubUser>
}