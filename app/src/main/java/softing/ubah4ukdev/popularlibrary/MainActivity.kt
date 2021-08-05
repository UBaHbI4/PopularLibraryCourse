package softing.ubah4ukdev.popularlibrary

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import softing.ubah4ukdev.populatelibrary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var vb: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)
    }
}