package softing.ubah4ukdev.popularlibrary

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import softing.ubah4ukdev.popularlibrary.App.Navigation.navigatorHolder
import softing.ubah4ukdev.popularlibrary.App.Navigation.router
import softing.ubah4ukdev.popularlibrary.presenter.MainPresenter
import softing.ubah4ukdev.popularlibrary.ui.IBackButtonListener
import softing.ubah4ukdev.popularlibrary.views.IMainView
import softing.ubah4ukdev.populatelibrary.R
import softing.ubah4ukdev.populatelibrary.databinding.ActivityMainBinding

class MainActivity : MvpAppCompatActivity(), IMainView {

    private var vb: ActivityMainBinding? = null

    private val presenter by moxyPresenter { MainPresenter(router) }
    val navigator = AppNavigator(this, R.id.container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)
    }

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