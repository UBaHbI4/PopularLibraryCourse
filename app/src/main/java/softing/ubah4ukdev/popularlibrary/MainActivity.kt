package softing.ubah4ukdev.popularlibrary

import androidx.core.view.ActionProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import softing.ubah4ukdev.popularlibrary.App.Navigation.navigatorHolder
import softing.ubah4ukdev.popularlibrary.App.Navigation.router
import softing.ubah4ukdev.popularlibrary.presenter.main.IMainView
import softing.ubah4ukdev.popularlibrary.presenter.main.MainPresenter
import softing.ubah4ukdev.popularlibrary.ui.IBackButtonListener
import softing.ubah4ukdev.populatelibrary.R


class MainActivity : MvpAppCompatActivity(R.layout.activity_main), IMainView {

    private val vb: ActionProvider by viewBinding()

    private val presenter by moxyPresenter { MainPresenter(router) }
    val navigator = AppNavigator(this, R.id.container)

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is IBackButtonListener && it.backPressed()) {
                return
            }
        }
        presenter.back()
    }
}