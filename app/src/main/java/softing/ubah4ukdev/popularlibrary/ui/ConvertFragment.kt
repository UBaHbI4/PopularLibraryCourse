package softing.ubah4ukdev.popularlibrary.ui

import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import softing.ubah4ukdev.popularlibrary.presenter.convert.ConvertPresenter
import softing.ubah4ukdev.popularlibrary.presenter.convert.IConvertView
import softing.ubah4ukdev.populatelibrary.R
import softing.ubah4ukdev.populatelibrary.databinding.FragmentConvertBinding

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.ui

Created by Ivan Sheynmaer

2021.08.14
v1.0
 */
class ConvertFragment : MvpAppCompatFragment(R.layout.fragment_convert), IConvertView {

    companion object {
        fun newInstance(): Fragment = ConvertFragment()
    }

    private val vb: FragmentConvertBinding by viewBinding()

    override fun showMessage(message: String) {

    }

    private val presenter: ConvertPresenter by moxyPresenter {
        ConvertPresenter()
    }
}