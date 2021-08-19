package softing.ubah4ukdev.popularlibrary.presenter.repodetail

import android.annotation.SuppressLint
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import moxy.MvpPresenter
import softing.ubah4ukdev.popularlibrary.domain.model.GitHubRepository
import softing.ubah4ukdev.popularlibrary.domain.repository.IRepository
import softing.ubah4ukdev.popularlibrary.scheduler.Schedulers

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.presenter.repodetail

Created by Ivan Sheynmaer

2021.08.16
v1.0
 */
class RepositoryPresenter(
    private val gitHubRepository: GitHubRepository,
    private val schedulers: Schedulers,
    private val repository: IRepository
) :
    MvpPresenter<IRepositoryView>() {

    private var disposables = CompositeDisposable()

    @SuppressLint("CheckResult")
    override fun onFirstViewAttach() {
        repository
            .fetchRepositoryInfo(gitHubRepository.login, gitHubRepository.name)
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

    fun setTitle() {
        viewState.setTitle(gitHubRepository.name.uppercase())
    }
}