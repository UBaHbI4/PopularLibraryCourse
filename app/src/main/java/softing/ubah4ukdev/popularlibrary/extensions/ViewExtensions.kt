package softing.ubah4ukdev.popularlibrary.extensions

import android.view.View
import com.google.android.material.snackbar.Snackbar

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.extensions

Created by Ivan Sheynmaer

2021.08.16
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

//Показать SnackBar c передачей текста в виде String
fun View.showSnakeBar(text: String, length: Int = Snackbar.LENGTH_INDEFINITE) {
    Snackbar.make(this, text, length).show()
}