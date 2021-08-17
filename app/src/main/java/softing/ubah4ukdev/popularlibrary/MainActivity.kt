package softing.ubah4ukdev.popularlibrary

import android.os.Bundle
import android.widget.Toast
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.androidx.AppNavigator
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import softing.ubah4ukdev.popularlibrary.App.Navigation.navigatorHolder
import softing.ubah4ukdev.popularlibrary.App.Navigation.router
import softing.ubah4ukdev.popularlibrary.domain.network.NetworkState
import softing.ubah4ukdev.popularlibrary.domain.network.NetworkStateObservable
import softing.ubah4ukdev.popularlibrary.presenter.convert.ConvertScreen
import softing.ubah4ukdev.popularlibrary.presenter.main.IMainView
import softing.ubah4ukdev.popularlibrary.presenter.main.MainPresenter
import softing.ubah4ukdev.popularlibrary.presenter.users.UsersScreen
import softing.ubah4ukdev.popularlibrary.ui.IBackButtonListener
import softing.ubah4ukdev.populatelibrary.R
import softing.ubah4ukdev.populatelibrary.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit


class MainActivity : MvpAppCompatActivity(R.layout.activity_main), IMainView {

    private val vb: ActivityMainBinding by viewBinding()

    private val presenter by moxyPresenter { MainPresenter(router) }
    private val navigator = AppNavigator(this, R.id.container)

    val disposables = CompositeDisposable()

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
    }

    private fun init() {
        vb.navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_users -> {
                    router.replaceScreen(UsersScreen.create())
                    true
                }
                R.id.navigation_convert -> {
                    router.replaceScreen(ConvertScreen().create())
                    true
                }
                else -> false
            }
        }

        router.replaceScreen(UsersScreen.create())

        val connect =
            NetworkStateObservable(this)
                .publish()

        connect.connect()

        disposables +=
            connect.delay(1L, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .subscribe { onNext(1, it) }
    }

    private fun onNext(no: Int, state: NetworkState) {
        Toast.makeText(this, "$no: NetworkState: $state", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()

        disposables.dispose()
    }

}