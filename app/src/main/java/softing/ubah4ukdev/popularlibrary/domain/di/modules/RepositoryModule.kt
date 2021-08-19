package softing.ubah4ukdev.popularlibrary.domain.di.modules

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import softing.ubah4ukdev.popularlibrary.MainActivity
import softing.ubah4ukdev.popularlibrary.domain.repository.IRepository
import softing.ubah4ukdev.popularlibrary.domain.repository.RepositoryImpl
import softing.ubah4ukdev.popularlibrary.domain.repository.datasource.CacheDataSourceImpl
import softing.ubah4ukdev.popularlibrary.domain.repository.datasource.ICacheDataSource
import softing.ubah4ukdev.popularlibrary.domain.repository.datasource.INetworkDataSource
import softing.ubah4ukdev.popularlibrary.domain.repository.datasource.NetworkDataSourceImpl
import softing.ubah4ukdev.popularlibrary.presenter.convert.ConvertFragment
import softing.ubah4ukdev.popularlibrary.presenter.repodetail.RepositoryFragment
import softing.ubah4ukdev.popularlibrary.presenter.user.UserFragment
import softing.ubah4ukdev.popularlibrary.presenter.users.UsersFragment
import javax.inject.Singleton

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.domain.di.modules

Created by Ivan Sheynmaer

2021.08.19
v1.0
 */
@Module
interface RepositoryModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindUsersFragment(): UsersFragment

    @ContributesAndroidInjector
    fun bindUserFragment(): UserFragment

    @ContributesAndroidInjector
    fun bindConvertFragment(): ConvertFragment

    @ContributesAndroidInjector
    fun bindRepositoryFragment(): RepositoryFragment

    @Singleton
    @Binds
    fun bindGitHubUserRepository(repository: RepositoryImpl): IRepository

    @Singleton
    @Binds
    fun bindUserDataSource(dataSource: CacheDataSourceImpl): ICacheDataSource

    @Singleton
    @Binds
    fun bindCacheUserDataSource(dataSource: NetworkDataSourceImpl): INetworkDataSource
}