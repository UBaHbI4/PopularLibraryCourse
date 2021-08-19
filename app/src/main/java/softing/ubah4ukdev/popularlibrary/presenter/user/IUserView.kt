package softing.ubah4ukdev.popularlibrary.presenter.user

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import softing.ubah4ukdev.popularlibrary.domain.model.GitHubRepository
import softing.ubah4ukdev.popularlibrary.domain.model.GithubUser

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.presenter

Created by Ivan Sheynmaer

2021.08.05
v1.0
 */
@SingleState
interface IUserView : MvpView {

    /**
     * Отобразить данные пользователя
     * @param user GithubUser
     */
    fun showUser(user: GithubUser)

    /**
     * Отобразить сообщение
     * @param message Текст сообщения
     */
    fun showMessage(message: String)

    /**
     * Отобразить список репозиториев в RV
     * @param repos Список репозиториев
     */
    fun showRepo(repos: List<GitHubRepository>)

    /**
     * Установить заголовок
     * @param title Текст заголовка
     */
    fun setTitle(title: String)
}