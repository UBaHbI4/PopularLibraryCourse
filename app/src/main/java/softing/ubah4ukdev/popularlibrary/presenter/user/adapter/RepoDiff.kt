package softing.ubah4ukdev.popularlibrary.presenter.user.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import softing.ubah4ukdev.popularlibrary.domain.model.GitHubRepository

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.presenter.user.adapter

Created by Ivan Sheynmaer

2021.08.16
v1.0
 */
object RepoDiff : DiffUtil.ItemCallback<GitHubRepository>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: GitHubRepository, newItem: GitHubRepository): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: GitHubRepository, newItem: GitHubRepository): Boolean {
        return oldItem.equals(newItem)
    }

    override fun getChangePayload(oldItem: GitHubRepository, newItem: GitHubRepository) = payload

}