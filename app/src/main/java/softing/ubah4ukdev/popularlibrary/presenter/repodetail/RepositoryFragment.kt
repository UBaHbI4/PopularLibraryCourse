package softing.ubah4ukdev.popularlibrary.presenter.repodetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.Router
import moxy.ktx.moxyPresenter
import softing.ubah4ukdev.popularlibrary.domain.model.GitHubRepository
import softing.ubah4ukdev.popularlibrary.domain.repository.IRepository
import softing.ubah4ukdev.popularlibrary.extensions.arguments
import softing.ubah4ukdev.popularlibrary.extensions.showSnakeBar
import softing.ubah4ukdev.popularlibrary.presenter.abs.AbsFragment
import softing.ubah4ukdev.popularlibrary.scheduler.Schedulers
import softing.ubah4ukdev.populatelibrary.R
import softing.ubah4ukdev.populatelibrary.databinding.FragmentRepositoryBinding
import javax.inject.Inject

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.presenter.repodetail

Created by Ivan Sheynmaer

2021.08.16
v1.0
 */
class RepositoryFragment : AbsFragment(R.layout.fragment_repository), IRepositoryView {

    companion object {
        private const val ARG_REPO = "arg_repo"

        fun newInstance(repo: GitHubRepository): Fragment = RepositoryFragment()
            .arguments(ARG_REPO to repo)
    }

    @Inject
    lateinit var repository: IRepository

    @Inject
    lateinit var schedulers: Schedulers

    @Inject
    lateinit var router: Router

    private val vb: FragmentRepositoryBinding by viewBinding()
    private val gitHubRepository: GitHubRepository? by lazy { arguments?.getParcelable(ARG_REPO) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.setTitle()
    }

    private val presenter: RepositoryPresenter by moxyPresenter {
        RepositoryPresenter(
            gitHubRepository = gitHubRepository ?: throw Throwable(IllegalArgumentException()),
            schedulers = schedulers,
            repository = repository
        )
    }

    override fun showDetail(repo: GitHubRepository) {

        with(vb) {
            repositoryId.text = repo.id
            repositoryName.text = repo.name
            repositoryDescription.text = "${repo.description}"
            repositoryLanguage.text = "${repo.language}"
            "${repo.forksCount} шт.".also { repositoryForksCount.text = it }
            repositoryBranch.text = "${repo.defaultBranch}"
            repositoryDateCreated.text = "${repo.createdAt}"
            repositorySize.text = "${repo.size}"
        }
    }

    override fun showMessage(message: String) {
        vb.root.showSnakeBar(text = message)
    }

    override fun setTitle(title: String) {
        requireActivity().title = title
    }
}