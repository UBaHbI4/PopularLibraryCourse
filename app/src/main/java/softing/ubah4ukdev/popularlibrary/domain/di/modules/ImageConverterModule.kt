package softing.ubah4ukdev.popularlibrary.domain.di.modules

import dagger.Binds
import dagger.Module
import softing.ubah4ukdev.popularlibrary.domain.converter.IImageConverter
import softing.ubah4ukdev.popularlibrary.domain.converter.ImageConverterImpl
import javax.inject.Singleton

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.domain.di.modules

Created by Ivan Sheynmaer

2021.08.19
v1.0
 */
@Module
interface ImageConverterModule {

    @Singleton
    @Binds
    fun bindImageConverter(converter: ImageConverterImpl): IImageConverter
}