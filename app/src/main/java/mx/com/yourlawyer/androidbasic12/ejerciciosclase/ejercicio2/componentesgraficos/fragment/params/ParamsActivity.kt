package mx.com.yourlawyer.androidbasic12.ejerciciosclase.ejercicio2.componentesgraficos.fragment.params

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mx.com.yourlawyer.androidbasic12.R
import mx.com.yourlawyer.androidbasic12.databinding.ActivityParamsBinding

class ParamsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityParamsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityParamsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment, SendParamsFragment.newInstance())
            .commit()

    }
}