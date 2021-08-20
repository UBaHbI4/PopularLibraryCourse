package softing.ubah4ukdev.popularlibrary.presenter.user.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import softing.ubah4ukdev.popularlibrary.domain.model.GitHubRepository
import softing.ubah4ukdev.populatelibrary.R

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.presenter.user.adapter

Created by Ivan Sheynmaer

2021.08.16
v1.0
 */
class RepositoriesAdapter(private val delegate: Delegate?) :
    ListAdapter<GitHubRepository, RepositoryViewHolder>(RepoDiff) {
    interface Delegate {

        /**
         * Событие наступает при выборе
         * репозитория из списка.
         * @param repository Репозиторий
         */
        fun onRepoPicked(repository: GitHubRepository)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder =
        RepositoryViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.repository, parent, false)
        )

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) =
        holder.bind(getItem(position), delegate)
}