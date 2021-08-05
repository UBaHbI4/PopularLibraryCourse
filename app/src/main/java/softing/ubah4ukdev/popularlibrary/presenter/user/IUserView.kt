package softing.ubah4ukdev.popularlibrary.presenter.user

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import softing.ubah4ukdev.popularlibrary.domain.model.GithubUser

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.presenter

Created by Ivan Sheynmaer

2021.08.05
v1.0
 */
@StateStrategyType(AddToEndSingleStrategy::class)
interface IUserView : MvpView {

    fun showUser(user: GithubUser)
}