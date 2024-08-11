package mx.com.yourlawyer.androidbasic12.ejerciciosclase.ejercicio2.componentesgraficos.viewbinding

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mx.com.yourlawyer.androidbasic12.R
import mx.com.yourlawyer.androidbasic12.databinding.ActivityImplicitIntentBinding
import mx.com.yourlawyer.androidbasic12.databinding.ActivityViewBindingExampleBinding

class ViewBindingExampleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewBindingExampleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBindingExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvName.text = "Hello Arthur"
        binding.tvSurname.text = "Morgan"
        binding.tvAge.text = "27"
    }
}