package softing.ubah4ukdev.popularlibrary.presenter.repodetail

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import softing.ubah4ukdev.popularlibrary.domain.model.GitHubRepository

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.presenter.repodetail

Created by Ivan Sheynmaer

2021.08.16
v1.0
 */
@SingleState
interface IRepositoryView : MvpView {

    /**
     * Отобразить информацию репозитория
     * @param repo GitHubRepository
     */
    fun showDetail(repo: GitHubRepository)

    /**
     * Отобразить сообщение
     * @param message Текст сообщения
     */
    fun showMessage(message: String)

    /**
     * Установить заголовок
     * @param title Текст заголовка
     */
    fun setTitle(title: String)
}