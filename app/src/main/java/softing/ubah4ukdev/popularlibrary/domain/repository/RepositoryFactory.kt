package softing.ubah4ukdev.popularlibrary.domain.repository

import softing.ubah4ukdev.popularlibrary.domain.repository.datasource.CacheDataSourceFactory
import softing.ubah4ukdev.popularlibrary.domain.repository.datasource.NetworkDataSourceFactory

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.domain.repository

Created by Ivan Sheynmaer

2021.08.14
v1.0
 */
object RepositoryFactory {

    private val repository: IRepository by lazy {
        RepositoryImpl(
            NetworkDataSourceFactory.create(),
            CacheDataSourceFactory.create()
        )
    }

    fun create(): IRepository = repository
}