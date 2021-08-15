package softing.ubah4ukdev.popularlibrary.presenter.users

import com.github.terrakok.cicerone.androidx.FragmentScreen

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.views

Created by Ivan Sheynmaer

2021.08.05
v1.0
 */
object UsersScreen {
    fun create() = FragmentScreen { UsersFragment.newInstance() }
}