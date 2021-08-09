package softing.ubah4ukdev.popularlibrary.ui


import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import softing.ubah4ukdev.popularlibrary.App.Navigation.router
import softing.ubah4ukdev.popularlibrary.domain.model.GithubUser
import softing.ubah4ukdev.popularlibrary.presenter.user.IUserView
import softing.ubah4ukdev.popularlibrary.presenter.user.UserPresenter
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

        fun newInstance(user: GithubUser): Fragment = UserFragment().apply {
            arguments = bundleOf(ARG_USER to user)
        }
    }

    private val vb: FragmentUserBinding by viewBinding()

    private val user: GithubUser? by lazy { arguments?.getParcelable(ARG_USER) }
    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(
            user = user,
            router = router
        )
    }

    override fun showUser(user: GithubUser) {
        vb.userLogin.text = user.login
    }

    override fun showMessage(message: String) {
        vb.root.showSnakeBar(message)
    }
}