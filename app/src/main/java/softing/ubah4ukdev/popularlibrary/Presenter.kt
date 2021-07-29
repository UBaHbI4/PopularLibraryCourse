package softing.ubah4ukdev.popularlibrary

import softing.ubah4ukdev.populatelibrary.R

/****
Project PopulateLibrary
Package softing.ubah4ukdev.populatelibrary

Created by Ivan Sheynmaer

2021.07.29
v1.0
 */
class Presenter(private val view: IView) : IPresenter {

    override fun init() {
        view.showCounter1("${Model[0]}")
        view.showCounter2("${Model[1]}")
        view.showCounter3("${Model[2]}")
    }

    override fun count(buttonId: Int) {
        when (buttonId) {
            R.id.btn_counter1 -> {
                view.showCounter1("${++Model[0]}")
            }
            R.id.btn_counter2 -> {
                view.showCounter2("${++Model[1]}")
            }
            R.id.btn_counter3 -> {
                view.showCounter3("${++Model[2]}")
            }
        }
    }
}