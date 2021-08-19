package softing.ubah4ukdev.popularlibrary.presenter.users

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.views

Created by Ivan Sheynmaer

2021.08.05
v1.0
 */
object UsersScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        UsersFragment.newInstance()
}