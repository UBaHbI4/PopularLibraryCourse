package softing.ubah4ukdev.popularlibrary.domain.repository.datasource

import softing.ubah4ukdev.popularlibrary.domain.api.GitHubApiFactory

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.domain.repository.datasource

Created by Ivan Sheynmaer

2021.08.17
v1.0
 */
object NetworkDataSourceFactory {

    fun create(): INetworkDataSource = NetworkDataSourceImpl(GitHubApiFactory.create())
}