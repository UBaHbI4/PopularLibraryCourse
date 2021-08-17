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
 */
interface IRepository {

    /**
     * Получить список пользователей
     * @return List of GithubUser
     */
    fun users(): Observable<List<GithubUser>>

    /**
     * Получить пользователя по логину
     * @param login Логин пользователя
     * @return GithubUser
     */
    fun userById(login: String): Maybe<GithubUser>

    /**
     * Получить информацию о репозитории
     * @param login Логин пользователя
     * @return GitHubRepository
     */
    fun repoInfo(login: String, name: String): Maybe<GitHubRepository>

    /**
     * Получить список репозиториев пользователя
     * @param login Логин пользователя
     * @return List of GithubUser
     */
    fun repoList(login: String): Observable<List<GitHubRepository>>
}