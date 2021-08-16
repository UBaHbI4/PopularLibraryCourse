package softing.ubah4ukdev.popularlibrary.presenter.user


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import softing.ubah4ukdev.popularlibrary.App.Navigation.router
import softing.ubah4ukdev.popularlibrary.domain.model.GitHubRepository
import softing.ubah4ukdev.popularlibrary.domain.model.GithubUser
import softing.ubah4ukdev.popularlibrary.domain.repository.UserRepositoryFactory
import softing.ubah4ukdev.popularlibrary.extensions.arguments
import softing.ubah4ukdev.popularlibrary.extensions.setStartDrawableCircleImageFromUri
import softing.ubah4ukdev.popularlibrary.extensions.visible
import softing.ubah4ukdev.popularlibrary.presenter.repodetail.RepositoryScreen
import softing.ubah4ukdev.popularlibrary.presenter.user.adapter.RepositoriesAdapter
import softing.ubah4ukdev.popularlibrary.presenter.users.UsersScreen
import softing.ubah4ukdev.popularlibrary.scheduler.SchedulerFactory
import softing.ubah4ukdev.popularlibrary.ui.extensions.showSnakeBar
import softing.ubah4ukdev.populatelibrary.R
import softing.ubah4ukdev.populatelibrary.databinding.FragmentUserBinding

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.presenter.users.adapter

Created by Ivan Sheynmaer

2021.08.05
v1.0
 */
class UserFragment : MvpAppCompatFragment(R.layout.fragment_user), IUserView,  RepositoriesAdapter.Delegate{
    companion object {

        private const val ARG_USER = "arg_user"
        private const val ERROR_VALUE = "-1"

        fun newInstance(login: String): Fragment = UserFragment()
            .arguments(ARG_USER to login)
    }

    private val vb: FragmentUserBinding by viewBinding()
    private val repoAdapter = RepositoriesAdapter(delegate = this)

    private val login: String? by lazy { arguments?.getString(ARG_USER) }
    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(
            login = login ?: ERROR_VALUE,
            router = router,
            UserRepositoryFactory.create(),
            SchedulerFactory.create()
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vb.repoTitle.visible { false }
        vb.rvRepos.adapter = repoAdapter
    }

    override fun showUser(user: GithubUser) {
        vb.tvLogin.text = user.login
        vb.tvLogin.setStartDrawableCircleImageFromUri(user.avatar)
    }

    override fun showMessage(message: String) {
        vb.root.showSnakeBar(message)
    }

    override fun showRepo(repos: List<GitHubRepository>) {
        vb.repoTitle.visible { true }
        repoAdapter.submitList(repos)
    }

    override fun onRepoPicked(repository: GitHubRepository) {
        router.replaceScreen(RepositoryScreen(repository).create())
    }
}