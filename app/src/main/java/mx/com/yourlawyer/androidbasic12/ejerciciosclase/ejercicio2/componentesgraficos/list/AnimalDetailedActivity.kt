package mx.com.yourlawyer.androidbasic12.ejerciciosclase.ejercicio2.componentesgraficos.list

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mx.com.yourlawyer.androidbasic12.R

class AnimalDetailedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_detailed)

        var tvAnimalName = findViewById<TextView>(R.id.tvAnimalName)
        val animal = intent.getSerializableExtra("animal") as AnimalEntity
        tvAnimalName.text = animal.name
    }
}