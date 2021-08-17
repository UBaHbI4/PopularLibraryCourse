package softing.ubah4ukdev.popularlibrary.presenter.users

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.presenter

Created by Ivan Sheynmaer

2021.08.05
v1.0
 */
@StateStrategyType(AddToEndSingleStrategy::class)
interface IUsersView : MvpView {

    /**
     * Инициализация RV
     */
    fun init()

    /**
     * Обновить список. в адаптере вызываем notifyDataSetChanged
     */
    fun updateList()

    /**
     * Отобразить сообщение
     * @param message Текст сообщения
     */
    fun showMessage(message: String)
}