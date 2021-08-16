package softing.ubah4ukdev.popularlibrary.presenter.user

import android.annotation.SuppressLint
import com.github.terrakok.cicerone.Router
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import moxy.MvpPresenter
import softing.ubah4ukdev.popularlibrary.domain.repository.IUsersRepository
import softing.ubah4ukdev.popularlibrary.presenter.users.UsersScreen
import softing.ubah4ukdev.popularlibrary.scheduler.Schedulers
import java.util.concurrent.TimeUnit

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
    private val repository: IUsersRepository,
    private val schedulers: Schedulers
) :
    MvpPresenter<IUserView>() {

    private var disposables = CompositeDisposable()

    @SuppressLint("CheckResult")
    override fun onFirstViewAttach() {
        repository
            .userById(login)
            .observeOn(schedulers.main())
            .subscribeOn(schedulers.background())
            .subscribe(
                viewState::showUser
            ) {
                viewState.showMessage(it.message.toString())
                router.replaceScreen(UsersScreen.create())
            }.addTo(disposables)

        repository
            .repoList(login)
            .observeOn(schedulers.main())
            .subscribeOn(schedulers.background())
            .subscribe(
                viewState::showRepo
            ) {
                viewState.showMessage(it.message.toString())
                router.replaceScreen(UsersScreen.create())
            }.addTo(disposables)
    }

    override fun onDestroy() {
        disposables.dispose()
    }
}