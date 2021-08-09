package softing.ubah4ukdev.popularlibrary.ui.extensions

import android.view.View
import com.google.android.material.snackbar.Snackbar

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.ui.extensions

Created by Ivan Sheynmaer

2021.08.09
v1.0
 */
fun View.visible(visible: () -> Boolean): View {
    visibility = if (visible()) {
        View.VISIBLE
    } else {
        View.GONE
    }
    return this
}

fun View.showSnakeBar(text: String, length: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this, text, length).show()
}