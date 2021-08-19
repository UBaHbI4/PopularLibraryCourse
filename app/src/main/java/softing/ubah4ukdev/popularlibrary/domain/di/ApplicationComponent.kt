package softing.ubah4ukdev.popularlibrary.domain.di

import android.content.Context
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import softing.ubah4ukdev.popularlibrary.App
import softing.ubah4ukdev.popularlibrary.domain.di.modules.GitHubApiModule
import softing.ubah4ukdev.popularlibrary.domain.di.modules.GitHubStorageModule
import softing.ubah4ukdev.popularlibrary.domain.di.modules.RepositoryModule
import softing.ubah4ukdev.popularlibrary.domain.di.modules.ImageConverterModule
import softing.ubah4ukdev.popularlibrary.scheduler.Schedulers
import javax.inject.Singleton

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.domain.di.modules

Created by Ivan Sheynmaer

2021.08.19
v1.0
 */

@Singleton
@Component(
    modules = [AndroidInjectionModule::class,
        RepositoryModule::class,
        GitHubApiModule::class,
        GitHubStorageModule::class,
        ImageConverterModule::class]
)
interface ApplicationComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withRouter(router: Router): Builder

        @BindsInstance
        fun withNavigatorHolder(navigatorHolder: NavigatorHolder): Builder

        @BindsInstance
        fun withSchedulers(schedulers: Schedulers): Builder

        fun build(): ApplicationComponent

    }
}