package softing.ubah4ukdev.popularlibrary.domain.repository.datasource

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
interface ICacheNetworkDataSource: INetworkDataSource {

    /**
     * Сохранить список пользователей
     * @param users Список пользователей
     * @return List of GithubUser
     */
    fun retainUsers(users: List<GithubUser>): Single<List<GithubUser>>

    /**
     * Обновить пользователя
     * @param user Пользователей
     * @return GithubUser
     */
    fun retainUser(user: GithubUser): Single<GithubUser>

    /**
     * Сохранить список репозиториев
     * @param repos Список репозиториев
     * @param login Логин пользователя
     * @return List of GitHubRepository
     */
    fun retainRepositories(repos: List<GitHubRepository>, login:String): Single<List<GitHubRepository>>

    /**
     * Обновить репозиторий
     * @param repo Репозиторий
     * @param login Логин пользователя
     * @return GitHubRepository
     */
    fun retainRepository(repo: GitHubRepository, login:String, name:String): Single<GitHubRepository>
}