package softing.ubah4ukdev.popularlibrary.presenter.user

import android.os.Handler
import android.os.Looper
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import softing.ubah4ukdev.popularlibrary.domain.model.GithubUser
import softing.ubah4ukdev.popularlibrary.presenter.users.UsersScreen

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.presenter

Created by Ivan Sheynmaer

2021.08.05
v1.0
 */
class UserPresenter(
    private val user: GithubUser?,
    private val router: Router
) :
    MvpPresenter<IUserView>() {

    companion object {
        const val CLOSE_DELAY = 800L
        const val ERROR_MESSAGE = "Не выбран пользователь!"
    }

    override fun onFirstViewAttach() {
        if (user != null) {
            viewState.showUser(user)
        } else {
            viewState.showMessage(ERROR_MESSAGE)
            Thread {
                Handler(Looper.getMainLooper()).postDelayed({
                    router.replaceScreen(UsersScreen.create())
                }, CLOSE_DELAY)
            }.start()
        }
    }
}