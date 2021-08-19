package softing.ubah4ukdev.popularlibrary.presenter.users

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.Router
import moxy.ktx.moxyPresenter
import softing.ubah4ukdev.popularlibrary.domain.repository.IRepository
import softing.ubah4ukdev.popularlibrary.extensions.showSnakeBar
import softing.ubah4ukdev.popularlibrary.presenter.abs.AbsFragment
import softing.ubah4ukdev.popularlibrary.presenter.users.adapter.UsersAdapter
import softing.ubah4ukdev.popularlibrary.scheduler.Schedulers
import softing.ubah4ukdev.popularlibrary.ui.IBackButtonListener
import softing.ubah4ukdev.populatelibrary.R
import softing.ubah4ukdev.populatelibrary.databinding.FragmentUsersBinding
import javax.inject.Inject

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.presenter.users.adapter

Created by Ivan Sheynmaer

2021.08.05
v1.0
 */
class UsersFragment : AbsFragment(R.layout.fragment_users), IUsersView
     {
    companion object {
        fun newInstance(): Fragment = UsersFragment()
    }

    @Inject
    lateinit var schedulers: Schedulers

    @Inject
    lateinit var Repository: IRepository

    @Inject
    lateinit var router: Router

    val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            repository = Repository,
            router = router,
            schedulers = schedulers
        )
    }
    var usersAdapter: UsersAdapter? = null

    private val vb: FragmentUsersBinding by viewBinding()

    override fun init() {
        vb.rvUsers.layoutManager = LinearLayoutManager(context)
        usersAdapter = UsersAdapter(presenter = presenter.usersListPresenter)
        vb.rvUsers.adapter = usersAdapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = getString(R.string.users_title)
    }

    override fun updateList() {
        usersAdapter?.notifyDataSetChanged()
    }

    override fun showMessage(message: String) {
        vb.root.showSnakeBar(message)
    }

}