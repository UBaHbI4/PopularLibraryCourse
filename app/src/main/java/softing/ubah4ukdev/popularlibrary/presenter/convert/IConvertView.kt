package softing.ubah4ukdev.popularlibrary.presenter.convert

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.presenter.convert

Created by Ivan Sheynmaer

2021.08.14
v1.0
 */
@SingleState
interface IConvertView : MvpView {

    fun showMessage(message: String)
}