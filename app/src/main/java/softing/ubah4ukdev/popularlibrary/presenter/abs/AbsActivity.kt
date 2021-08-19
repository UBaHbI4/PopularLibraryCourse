package softing.ubah4ukdev.popularlibrary.presenter.abs

import android.os.Bundle
import androidx.annotation.LayoutRes
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import moxy.MvpAppCompatActivity
import javax.inject.Inject

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.presenter.abs

Created by Ivan Sheynmaer

2021.08.19
v1.0
 */
abstract class AbsActivity(@LayoutRes contentLayoutId: Int = 0) :
    MvpAppCompatActivity(contentLayoutId),
    HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }

}