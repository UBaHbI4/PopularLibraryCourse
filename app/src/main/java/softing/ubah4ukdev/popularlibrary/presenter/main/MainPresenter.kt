package softing.ubah4ukdev.popularlibrary.presenter.main

import android.annotation.SuppressLint
import android.util.Log
import com.github.terrakok.cicerone.Router
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import moxy.MvpPresenter
import softing.ubah4ukdev.popularlibrary.presenter.users.UsersScreen
import java.util.concurrent.TimeUnit
import kotlin.random.Random

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.presenter

Created by Ivan Sheynmaer

2021.08.05
v1.0
 */
class MainPresenter(
    private val router: Router,
) : MvpPresenter<IMainView>() {

    private var disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(UsersScreen.create())
    }

    fun back() = router.exit()

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
}