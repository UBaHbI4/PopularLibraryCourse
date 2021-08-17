package softing.ubah4ukdev.popularlibrary

import android.app.Application
import android.content.Context
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary

Created by Ivan Sheynmaer

2021.08.05
v1.0
 */
class App : Application() {

    object ContextHolder {
        lateinit var context: Context
    }

    companion object Navigation {

        private val cicerone: Cicerone<Router> by lazy {
            Cicerone.create()
        }

        val navigatorHolder = cicerone.getNavigatorHolder()
        val router = cicerone.router
    }

    override fun onCreate() {
        super.onCreate()
        ContextHolder.context = applicationContext
    }
}