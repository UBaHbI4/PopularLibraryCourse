package softing.ubah4ukdev.popularlibrary.domain.di.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import softing.ubah4ukdev.popularlibrary.domain.di.InMemory
import softing.ubah4ukdev.popularlibrary.domain.di.Persisted
import softing.ubah4ukdev.popularlibrary.domain.storage.GitHubStorage

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.domain.api

Created by Ivan Sheynmaer

2021.08.19
v1.0
 */
@Module
class GitHubStorageModule {

    @Persisted
    @Provides
    fun provideGitHubDatabaseStorage(context: Context): GitHubStorage =
        Room.databaseBuilder(context, GitHubStorage::class.java, "github.db")
            .build()

    @InMemory
    @Provides
    fun provideGitHubInMemoryDatabaseStorage(context: Context): GitHubStorage =
        Room.inMemoryDatabaseBuilder(context, GitHubStorage::class.java)
            .fallbackToDestructiveMigration()
            .build()
}