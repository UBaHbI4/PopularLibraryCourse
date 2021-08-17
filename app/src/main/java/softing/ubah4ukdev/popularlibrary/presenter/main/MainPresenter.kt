package softing.ubah4ukdev.popularlibrary.presenter.main

import com.github.terrakok.cicerone.Router
import io.reactivex.disposables.CompositeDisposable
import moxy.MvpPresenter

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

    fun back() = router.exit()

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
}