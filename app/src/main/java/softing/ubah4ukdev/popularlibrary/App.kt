package softing.ubah4ukdev.popularlibrary

import com.github.terrakok.cicerone.Cicerone
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import softing.ubah4ukdev.popularlibrary.domain.di.DaggerApplicationComponent
import softing.ubah4ukdev.popularlibrary.scheduler.DefaultSchedulers

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary

Created by Ivan Sheynmaer

2021.08.05
v1.0
 */
class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<App> =
        DaggerApplicationComponent
            .builder()
            .withContext(applicationContext)
            .apply {
                val cicerone = Cicerone.create()

                withNavigatorHolder(cicerone.getNavigatorHolder())
                withRouter(cicerone.router)
                withSchedulers(DefaultSchedulers())
            }
            .build()
}