package softing.ubah4ukdev.popularlibrary.presenter.user

import moxy.MvpPresenter
import softing.ubah4ukdev.popularlibrary.domain.model.GithubUser

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.presenter

Created by Ivan Sheynmaer

2021.08.05
v1.0
 */
class UserPresenter(private val user: GithubUser?) : MvpPresenter<IUserView>() {

    override fun onFirstViewAttach() {
        user?.let {
            viewState.showUser(it)
        }
    }
}