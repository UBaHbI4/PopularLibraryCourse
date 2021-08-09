package softing.ubah4ukdev.popularlibrary.presenter.user

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
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

    fun showUser(user: GithubUser)

    fun showMessage(message: String)
}