package softing.ubah4ukdev.popularlibrary.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
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
@Entity(tableName = "github_user")
data class GithubUser(

    @PrimaryKey
    @SerializedName("id")
    val userId: String,

    @ColumnInfo(name = "login")
    @SerializedName("login")
    val login: String,

    @ColumnInfo(name = "avatar_url")
    @SerializedName("avatar_url")
    val avatar: String,

    @SerializedName("repos_url")
    val repos: String

) : Parcelable