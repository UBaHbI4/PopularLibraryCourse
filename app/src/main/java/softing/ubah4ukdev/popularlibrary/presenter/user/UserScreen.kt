package softing.ubah4ukdev.popularlibrary.presenter.user

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import softing.ubah4ukdev.popularlibrary.ui.UserFragment

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.views

Created by Ivan Sheynmaer

2021.08.05
v1.0
 */
class UserScreen(private val userId: Int) {
    fun create(): Screen = FragmentScreen { UserFragment.newInstance(userId) }
}