package softing.ubah4ukdev.popularlibrary.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.domain.model

Created by Ivan Sheynmaer

2021.08.05
v1.0
 */
@Parcelize
data class GithubUser(
    val userId: Int,
    val login: String
) : Parcelable