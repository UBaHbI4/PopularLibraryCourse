package softing.ubah4ukdev.popularlibrary.presenter.repodetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import softing.ubah4ukdev.popularlibrary.domain.model.GitHubRepository
import softing.ubah4ukdev.popularlibrary.extensions.arguments
import softing.ubah4ukdev.populatelibrary.R
import softing.ubah4ukdev.populatelibrary.databinding.FragmentRepositoryBinding

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.presenter.repodetail

Created by Ivan Sheynmaer

2021.08.16
v1.0
 */
class RepositoryFragment : MvpAppCompatFragment(R.layout.fragment_repository), IRepositoryView {

    companion object {
        private const val ARG_REPO = "arg_repo"

        fun newInstance(repo: GitHubRepository): Fragment = RepositoryFragment()
            .arguments(ARG_REPO to repo)
    }

    private val vb: FragmentRepositoryBinding by viewBinding()
    private val repo: GitHubRepository? by lazy { arguments?.getParcelable(ARG_REPO) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = repo?.name
    }

    private val presenter: RepositoryPresenter by moxyPresenter {
        RepositoryPresenter(
            repo = repo ?: throw Throwable(IllegalArgumentException())
        )
    }

    override fun showDetail(repo: GitHubRepository) {

        with(vb) {
            repoId.text = "id: ${repo.id}"
            repoName.text = "Название: ${repo.name}"
            repoDescription.text = "Описание: ${repo.description}"
            repoLanguage.text = "Язык: ${repo.language}"
            repoForksCount.text = "Форков ${repo.forksCount} шт."
            repoBranch.text = "Ветка по умолчанию: ${repo.defaultBranch}"
            repoDateCreated.text = "Дата создания: ${repo.createdAt}"
            repoSize.text = "Размер репозитория: ${repo.size}"
        }
    }
}