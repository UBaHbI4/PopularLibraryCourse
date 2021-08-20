package softing.ubah4ukdev.popularlibrary.presenter.user.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.kirich1409.viewbindingdelegate.viewBinding
import softing.ubah4ukdev.popularlibrary.domain.model.GitHubRepository
import softing.ubah4ukdev.popularlibrary.extensions.click
import softing.ubah4ukdev.populatelibrary.databinding.RepositoryBinding

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.presenter.user.adapter

Created by Ivan Sheynmaer

2021.08.16
v1.0
 */
class RepositoryViewHolder(view: View) : ViewHolder(view) {
    private val viewBinding: RepositoryBinding by viewBinding()

    fun bind(repo: GitHubRepository, delegate: RepositoriesAdapter.Delegate?) {
        with(viewBinding) {
            repoName.text = repo.name
            root.click { delegate?.onRepoPicked(repo) }
        }
    }
}