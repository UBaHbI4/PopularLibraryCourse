package softing.ubah4ukdev.populatelibrary

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import softing.ubah4ukdev.populatelibrary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        const val ARG_COUNTERS = "counters"
    }

    private var vb: ActivityMainBinding? = null
    val counters = mutableListOf(0, 0, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)

        vb?.btnCounter1?.setOnClickListener { vb?.btnCounter1?.text = (++counters[0]).toString() }
        vb?.btnCounter2?.setOnClickListener { vb?.btnCounter2?.text = (++counters[1]).toString() }
        vb?.btnCounter3?.setOnClickListener { vb?.btnCounter3?.text = (++counters[2]).toString() }

        initViews()

    }

    private fun initViews() {
        vb?.btnCounter1?.text = counters[0].toString()
        vb?.btnCounter2?.text = counters[1].toString()
        vb?.btnCounter3?.text = counters[2].toString()
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putIntArray(ARG_COUNTERS, counters.toIntArray())
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntArray(ARG_COUNTERS, counters.toIntArray())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val countersArray = savedInstanceState.getIntArray(ARG_COUNTERS)
        countersArray?.toList()?.let {
            counters.clear()
            counters.addAll(it)
        }
        initViews()
    }
}