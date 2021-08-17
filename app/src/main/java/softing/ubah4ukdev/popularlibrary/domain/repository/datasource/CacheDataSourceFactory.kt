package softing.ubah4ukdev.popularlibrary.domain.repository.datasource

import softing.ubah4ukdev.popularlibrary.App.ContextHolder
import softing.ubah4ukdev.popularlibrary.domain.storage.GitHubStorageFactory

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.domain.repository.datasource

Created by Ivan Sheynmaer

2021.08.17
v1.0
 */
object CacheDataSourceFactory {

    fun create(): ICacheNetworkDataSource =
        CacheNetworkDataSourceImpl(
            GitHubStorageFactory.create(ContextHolder.context)
        )
}