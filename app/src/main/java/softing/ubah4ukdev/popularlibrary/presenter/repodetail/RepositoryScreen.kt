package softing.ubah4ukdev.popularlibrary.presenter.repodetail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import softing.ubah4ukdev.popularlibrary.domain.model.GitHubRepository

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.presenter.repodetail

Created by Ivan Sheynmaer

2021.08.16
v1.0
 */
class RepositoryScreen(
    private val repository: GitHubRepository,
) : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        RepositoryFragment.newInstance(repository)
}