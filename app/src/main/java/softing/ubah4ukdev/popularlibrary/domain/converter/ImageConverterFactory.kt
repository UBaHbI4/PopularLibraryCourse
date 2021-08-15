package softing.ubah4ukdev.popularlibrary.domain.converter

import android.content.Context

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.domain.converter

Created by Ivan Sheynmaer

2021.08.14
v1.0
 */
object ImageConverterFactory {

    fun create(context: Context): IImageConverter = ImageConverterImpl(context)
}