package softing.ubah4ukdev.popularlibrary.presenter.user

import android.annotation.SuppressLint
import com.github.terrakok.cicerone.Router
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import moxy.MvpPresenter
import softing.ubah4ukdev.popularlibrary.domain.repository.IRepository
import softing.ubah4ukdev.popularlibrary.presenter.users.UsersScreen
import softing.ubah4ukdev.popularlibrary.scheduler.Schedulers

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.presenter

Created by Ivan Sheynmaer

2021.08.05
v1.0
 */
class UserPresenter(
    private val login: String,
    private val router: Router,
    private val repository: IRepository,
    private val schedulers: Schedulers
) :
    MvpPresenter<IUserView>() {

    private var disposables = CompositeDisposable()


    @SuppressLint("CheckResult")
    override fun onFirstViewAttach() {
        repository
            .fetchUserByLogin(login = login)
            .observeOn(schedulers.main())
            .subscribeOn(schedulers.background())
            .subscribe(
                viewState::showUser
            ) { throwable ->
                viewState.showMessage(message = throwable.message.toString())
                router.backTo(UsersScreen)
            }.addTo(disposables)

        repository
            .fetchUserRepositoriesByLogin(login = login)
            .observeOn(schedulers.main())
            .subscribeOn(schedulers.background())
            .subscribe(
                viewState::showRepositories
            ) { throwable ->
                viewState.showMessage(message = throwable.message.toString())
            }.addTo(disposables)
    }

    override fun onDestroy() {
        disposables.dispose()
    }

    fun setTitle() {
        viewState.setTitle(login.uppercase())
    }
}