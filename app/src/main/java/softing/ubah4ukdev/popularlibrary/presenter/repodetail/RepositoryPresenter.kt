package softing.ubah4ukdev.popularlibrary.presenter.repodetail

import android.annotation.SuppressLint
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import moxy.MvpPresenter
import softing.ubah4ukdev.popularlibrary.App.Navigation.router
import softing.ubah4ukdev.popularlibrary.domain.model.GitHubRepository
import softing.ubah4ukdev.popularlibrary.domain.repository.IRepository
import softing.ubah4ukdev.popularlibrary.presenter.user.UserScreen
import softing.ubah4ukdev.popularlibrary.scheduler.Schedulers

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.presenter.repodetail

Created by Ivan Sheynmaer

2021.08.16
v1.0
 */
class RepositoryPresenter(
    private val repoItem: GitHubRepository,
    private val schedulers: Schedulers,
    private val repository: IRepository
) :
    MvpPresenter<IRepositoryView>() {

    private var disposables = CompositeDisposable()

    @SuppressLint("CheckResult")
    override fun onFirstViewAttach() {
        repository
            .repoInfo(repoItem.login, repoItem.name)
            .observeOn(schedulers.main())
            .subscribeOn(schedulers.background())
            .subscribe(
                viewState::showDetail
            ) {
                viewState.showMessage(it.message.toString())
            }.addTo(disposables)
    }

    override fun onDestroy() {
        disposables.dispose()
    }

    fun backPressed(): Boolean {
        router.replaceScreen(UserScreen(repoItem.login).create())
        return true
    }
}