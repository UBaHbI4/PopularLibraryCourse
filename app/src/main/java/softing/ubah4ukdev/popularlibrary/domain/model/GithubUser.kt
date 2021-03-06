package softing.ubah4ukdev.popularlibrary.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
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
    @SerializedName("id")
    val userId: String,

    @SerializedName("login")
    val login: String,

    @SerializedName("avatar_url")
    val avatar: String,

    @SerializedName("repos_url")
    val repos: String

) : Parcelable