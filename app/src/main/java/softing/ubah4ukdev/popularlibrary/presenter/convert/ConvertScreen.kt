package softing.ubah4ukdev.popularlibrary.presenter.convert

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import softing.ubah4ukdev.popularlibrary.ui.ConvertFragment

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.presenter.convert

Created by Ivan Sheynmaer

2021.08.14
v1.0
 */
class ConvertScreen() {

    fun create(): Screen = FragmentScreen { ConvertFragment.newInstance() }
}