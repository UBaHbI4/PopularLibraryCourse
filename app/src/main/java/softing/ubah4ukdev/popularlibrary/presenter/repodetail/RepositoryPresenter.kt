package softing.ubah4ukdev.popularlibrary.presenter.repodetail

import moxy.MvpPresenter
import softing.ubah4ukdev.popularlibrary.domain.model.GitHubRepository

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.presenter.repodetail

Created by Ivan Sheynmaer

2021.08.16
v1.0
 */
class RepositoryPresenter(private val repo: GitHubRepository) : MvpPresenter<IRepositoryView>() {

    override fun onFirstViewAttach() {
        viewState.showDetail(repo)
    }

    fun setTitle() {
        viewState.setTitle(repo.name)
    }
}