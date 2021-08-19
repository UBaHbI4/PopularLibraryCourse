package softing.ubah4ukdev.popularlibrary.presenter.user


import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import softing.ubah4ukdev.popularlibrary.App.Navigation.router
import softing.ubah4ukdev.popularlibrary.domain.model.GithubUser
import softing.ubah4ukdev.popularlibrary.domain.repository.UserRepositoryFactory
import softing.ubah4ukdev.popularlibrary.extensions.arguments
import softing.ubah4ukdev.popularlibrary.extensions.setStartDrawableCircleImageFromUri
import softing.ubah4ukdev.popularlibrary.scheduler.SchedulerFactory
import softing.ubah4ukdev.popularlibrary.ui.extensions.showSnakeBar
import softing.ubah4ukdev.populatelibrary.R
import softing.ubah4ukdev.populatelibrary.databinding.FragmentUserBinding

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.ui.adapter

Created by Ivan Sheynmaer

2021.08.05
v1.0
 */
class UserFragment : MvpAppCompatFragment(R.layout.fragment_user), IUserView {
    companion object {

        private const val ARG_USER = "arg_user"
        private const val ERROR_VALUE = "-1"

        fun newInstance(login: String): Fragment = UserFragment()
            .arguments(ARG_USER to login)
    }

    private val vb: FragmentUserBinding by viewBinding()

    private val login: String? by lazy { arguments?.getString(ARG_USER) }
    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(
            login = login ?: ERROR_VALUE,
            router = router,
            UserRepositoryFactory.create(),
            SchedulerFactory.create()
        )
    }

    override fun showUser(user: GithubUser) {
        vb.tvLogin.text = user.login
        vb.tvLogin.setStartDrawableCircleImageFromUri(user.avatar)
    }

    override fun showMessage(message: String) {
        vb.root.showSnakeBar(message)
    }
}