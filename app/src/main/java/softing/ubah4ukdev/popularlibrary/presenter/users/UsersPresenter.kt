package softing.ubah4ukdev.popularlibrary.presenter.users

import android.util.Log
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import softing.ubah4ukdev.popularlibrary.domain.model.GithubUser
import softing.ubah4ukdev.popularlibrary.domain.repository.MockUsersRepositoryImpl
import softing.ubah4ukdev.popularlibrary.presenter.IUserListPresenter
import softing.ubah4ukdev.popularlibrary.presenter.user.UserScreen
import softing.ubah4ukdev.popularlibrary.ui.IUserItemView

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.presenter

Created by Ivan Sheynmaer

2021.08.05
v1.0
 */
class UsersPresenter(
    private val mockUsersRepositoryImpl: MockUsersRepositoryImpl,
    private val router: Router
) :
    MvpPresenter<IUsersView>() {
    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<GithubUser>()
        override var itemClickListener: ((IUserItemView) -> Unit)? = null

        override fun getCount() = users.size

        override fun bindView(view: IUserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
    }

    private fun loadData() {
        val users = mockUsersRepositoryImpl.users()

        usersListPresenter.itemClickListener = { itemView ->
            Log.d("popLibDEBUG", itemView.toString())
            router.navigateTo(UserScreen(users[itemView.pos]).create())
        }

        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}