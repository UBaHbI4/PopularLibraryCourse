package softing.ubah4ukdev.popularlibrary.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.domain.model

Created by Ivan Sheynmaer

2021.08.16
v1.0
 */
@Parcelize
data class GitHubRepository(
    @SerializedName("id")
    val id: String,

    @SerializedName("login")
    val login: String = "",

    @SerializedName("name")
    val name: String,

    @SerializedName("description")
    val description: String?,

    @SerializedName("language")
    val language: String?,

    @SerializedName("forks_count")
    val forksCount: Int?,

    @SerializedName("defaulth_branch")
    val defaultBranch: String?,

    @SerializedName("created_at")
    val createdAt: String?,

    @SerializedName("size")
    val size: Int?,
) : Parcelable