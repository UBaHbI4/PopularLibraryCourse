package softing.ubah4ukdev.popularlibrary.presenter.repodetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import softing.ubah4ukdev.popularlibrary.domain.model.GitHubRepository
import softing.ubah4ukdev.popularlibrary.domain.repository.RepositoryFactory
import softing.ubah4ukdev.popularlibrary.extensions.arguments
import softing.ubah4ukdev.popularlibrary.extensions.showSnakeBar
import softing.ubah4ukdev.popularlibrary.scheduler.SchedulerFactory
import softing.ubah4ukdev.popularlibrary.ui.IBackButtonListener
import softing.ubah4ukdev.populatelibrary.R
import softing.ubah4ukdev.populatelibrary.databinding.FragmentRepositoryBinding

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.presenter.repodetail

Created by Ivan Sheynmaer

2021.08.16
v1.0
 */
class RepositoryFragment : MvpAppCompatFragment(R.layout.fragment_repository), IRepositoryView,
    IBackButtonListener {

    companion object {
        private const val ARG_REPO = "arg_repo"

        fun newInstance(repo: GitHubRepository): Fragment = RepositoryFragment()
            .arguments(ARG_REPO to repo)
    }

    private val vb: FragmentRepositoryBinding by viewBinding()
    private val repo: GitHubRepository? by lazy { arguments?.getParcelable(ARG_REPO) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        repo?.name?.let { requireActivity().title = it.uppercase() }
    }

    private val presenter: RepositoryPresenter by moxyPresenter {
        RepositoryPresenter(
            repoItem = repo ?: throw Throwable(IllegalArgumentException()),
            schedulers = SchedulerFactory.create(),
            repository = RepositoryFactory.create()
        )
    }

    override fun showDetail(repo: GitHubRepository) {

        with(vb) {
            repoId.text = repo.id
            repoName.text = repo.name
            repoDescription.text = "${repo.description}"
            repoLanguage.text = "${repo.language}"
            "${repo.forksCount} шт.".also { repoForksCount.text = it }
            repoBranch.text = "${repo.defaultBranch}"
            repoDateCreated.text = "${repo.createdAt}"
            repoSize.text = "${repo.size}"
        }
    }

    override fun showMessage(message: String) {
        vb.root.showSnakeBar(text = message)
    }

    override fun backPressed(): Boolean = presenter.backPressed()
}