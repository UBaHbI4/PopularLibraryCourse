package softing.ubah4ukdev.popularlibrary.domain.repository.datasource

import io.reactivex.Maybe
import io.reactivex.Single
import softing.ubah4ukdev.popularlibrary.domain.model.GitHubRepository
import softing.ubah4ukdev.popularlibrary.domain.model.GithubUser

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.domain.repository.datasource

Created by Ivan Sheynmaer

2021.08.17
v1.0
 */
interface INetworkDataSource {

    /**
     * Получить список пользователей
     * @return Список пользователей List of GithubUser
     */
    fun fetchUsers(): Single<List<GithubUser>>

    /**
     * Получить пользователя по логину
     * @param login Логин пользователя
     * @return GithubUser
     */
    fun fetchUserByLogin(login: String): Maybe<GithubUser>

    /**
     * Получить список репозиториев пользователя
     * @param login Логин пользователя
     * @return List of GitHubRepository
     */
    fun fetchUserRepositories(login: String): Single<List<GitHubRepository>>

    /**
     * Получить информацию о репозитории
     * @param login Логин пользователя
     * @param repositoryName Название репозитория
     * @return GitHubRepository
     */
    fun fetchRepositoryInfo(login: String, repositoryName: String): Single<GitHubRepository>
}