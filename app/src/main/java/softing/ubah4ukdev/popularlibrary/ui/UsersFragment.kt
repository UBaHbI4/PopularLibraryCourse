package softing.ubah4ukdev.popularlibrary.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import softing.ubah4ukdev.popularlibrary.App
import softing.ubah4ukdev.popularlibrary.domain.repository.MockUsersRepositoryImpl
import softing.ubah4ukdev.popularlibrary.presenter.users.IUsersView
import softing.ubah4ukdev.popularlibrary.presenter.users.UsersPresenter
import softing.ubah4ukdev.popularlibrary.ui.adapter.UsersAdapter
import softing.ubah4ukdev.populatelibrary.databinding.FragmentUsersBinding

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.ui.adapter

Created by Ivan Sheynmaer

2021.08.05
v1.0
 */
class UsersFragment : MvpAppCompatFragment(), IUsersView, IBackButtonListener {
    companion object {
        fun newInstance() = UsersFragment()
    }

    val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            MockUsersRepositoryImpl,
            App.router
        )
    }
    var adapter: UsersAdapter? = null

    private var vb: FragmentUsersBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        FragmentUsersBinding.inflate(inflater, container, false).also {
            vb = it
        }.root

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun init() {
        vb?.rvUsers?.layoutManager = LinearLayoutManager(context)
        adapter = UsersAdapter(presenter.usersListPresenter)
        vb?.rvUsers?.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()
}