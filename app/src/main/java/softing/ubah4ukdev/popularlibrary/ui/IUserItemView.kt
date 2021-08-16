package softing.ubah4ukdev.popularlibrary.ui

import softing.ubah4ukdev.popularlibrary.presenter.user.IItemView

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.ui.adapter

Created by Ivan Sheynmaer

2021.08.05
v1.0
 */
interface IUserItemView : IItemView {

    fun setUser(login: String, avatar: String)
}