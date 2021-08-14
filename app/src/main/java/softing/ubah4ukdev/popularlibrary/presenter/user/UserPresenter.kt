package softing.ubah4ukdev.popularlibrary.presenter.user

import android.annotation.SuppressLint
import com.github.terrakok.cicerone.Router
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import moxy.MvpPresenter
import softing.ubah4ukdev.popularlibrary.domain.repository.IUsersRepository
import softing.ubah4ukdev.popularlibrary.domain.repository.MockUsersRepositoryImpl
import softing.ubah4ukdev.popularlibrary.domain.repository.UserRepositoryFactory
import softing.ubah4ukdev.popularlibrary.presenter.users.UsersScreen

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.presenter

Created by Ivan Sheynmaer

2021.08.05
v1.0
 */
class UserPresenter(
    private val userId: Int,
    private val router: Router,
    private val repository: IUsersRepository,
) :
    MvpPresenter<IUserView>() {

    private var disposables = CompositeDisposable()

    @SuppressLint("CheckResult")
    override fun onFirstViewAttach() {
        repository
            .userById(userId)
            .subscribe(
                viewState::showUser
            ) {
                viewState.showMessage(it.message.toString())
                router.replaceScreen(UsersScreen.create())
            }.addTo(disposables)
    }

    override fun onDestroy() {
        disposables.dispose()
    }
}