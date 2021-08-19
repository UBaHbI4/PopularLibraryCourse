package softing.ubah4ukdev.popularlibrary.domain.converter

import android.net.Uri
import io.reactivex.Single
import java.io.File

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.domain.converter

Created by Ivan Sheynmaer

2021.08.14
v1.0
 */
interface IImageConverter {

    /**
     * @param uriTargetImage Uri исходного изображения
     * @param toFile файл, в который записывается конвертированная картинка
     * @return Uri результирующего изображения
     */
    fun jpegToPng(uriTargetImage: Uri, toFile: File): Single<Uri>
}