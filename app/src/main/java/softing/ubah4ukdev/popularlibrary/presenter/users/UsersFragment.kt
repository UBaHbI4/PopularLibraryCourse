package softing.ubah4ukdev.popularlibrary.presenter.users

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import softing.ubah4ukdev.popularlibrary.App
import softing.ubah4ukdev.popularlibrary.domain.repository.RepositoryFactory
import softing.ubah4ukdev.popularlibrary.extensions.showSnakeBar
import softing.ubah4ukdev.popularlibrary.presenter.users.adapter.UsersAdapter
import softing.ubah4ukdev.popularlibrary.scheduler.SchedulerFactory
import softing.ubah4ukdev.popularlibrary.ui.IBackButtonListener
import softing.ubah4ukdev.populatelibrary.R
import softing.ubah4ukdev.populatelibrary.databinding.FragmentUsersBinding

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.presenter.users.adapter

Created by Ivan Sheynmaer

2021.08.05
v1.0
 */
class UsersFragment : MvpAppCompatFragment(R.layout.fragment_users), IUsersView,
    IBackButtonListener {
    companion object {
        fun newInstance(): Fragment = UsersFragment()
    }

    val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            repository = RepositoryFactory.create(),
            router = App.router,
            schedulers = SchedulerFactory.create()
        )
    }
    var adapter: UsersAdapter? = null

    private val vb: FragmentUsersBinding by viewBinding()

    override fun init() {
        vb.rvUsers.layoutManager = LinearLayoutManager(context)
        adapter = UsersAdapter(presenter = presenter.usersListPresenter)
        vb.rvUsers.adapter = adapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = getString(R.string.users_title)
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun showMessage(message: String) {
        vb.root.showSnakeBar(message)
    }

    override fun backPressed() = presenter.backPressed()
}