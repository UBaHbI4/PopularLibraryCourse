package softing.ubah4ukdev.popularlibrary.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import softing.ubah4ukdev.popularlibrary.domain.model.GithubUser
import softing.ubah4ukdev.popularlibrary.presenter.user.IUserView
import softing.ubah4ukdev.popularlibrary.presenter.user.UserPresenter
import softing.ubah4ukdev.populatelibrary.databinding.FragmentUserBinding

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.ui.adapter

Created by Ivan Sheynmaer

2021.08.05
v1.0
 */
class UserFragment : MvpAppCompatFragment(), IUserView {
    companion object {

        private const val ARG_USER = "arg_user"

        fun newInstance(user: GithubUser) = UserFragment().apply {
            arguments = bundleOf(ARG_USER to user)
        }
    }

    private val user: GithubUser? by lazy { arguments?.getParcelable(ARG_USER) }
    private val presenter: UserPresenter by moxyPresenter { UserPresenter(user = user) }
    private var vb: FragmentUserBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        FragmentUserBinding.inflate(inflater, container, false).also {
            vb = it
        }.root

    override fun showUser(user: GithubUser) {
        vb?.userLogin?.text = user.login
    }
}