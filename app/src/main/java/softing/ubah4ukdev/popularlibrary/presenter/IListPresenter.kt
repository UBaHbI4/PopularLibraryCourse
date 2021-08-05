package softing.ubah4ukdev.popularlibrary.presenter

import softing.ubah4ukdev.popularlibrary.views.IItemView

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.ui.adapter

Created by Ivan Sheynmaer

2021.08.05
v1.0
 */
interface IListPresenter<V : IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}