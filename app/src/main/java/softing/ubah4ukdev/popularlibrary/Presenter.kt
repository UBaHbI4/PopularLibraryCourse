package softing.ubah4ukdev.popularlibrary

/****
Project PopulateLibrary
Package softing.ubah4ukdev.popularlibrary

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

    override fun count1() {
        view.showCounter1("${++Model[0]}")
    }

    override fun count2() {
        view.showCounter2("${++Model[1]}")
    }

    override fun count3() {
        view.showCounter3("${++Model[2]}")
    }
}