package softing.ubah4ukdev.popularlibrary.presenter.repodetail

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import softing.ubah4ukdev.popularlibrary.domain.model.GitHubRepository

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.presenter.repodetail

Created by Ivan Sheynmaer

2021.08.16
v1.0
 */
@SingleState
interface IRepositoryView : MvpView {

    fun showDetail(repo: GitHubRepository)

    fun setTitle(title: String)
}