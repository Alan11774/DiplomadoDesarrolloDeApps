package mx.com.yourlawyer.androidbasic12.ejerciciosclase.ejercicio2.componentesgraficos.personslist

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mx.com.yourlawyer.androidbasic12.R
import mx.com.yourlawyer.androidbasic12.ejerciciosclase.ejercicio2.componentesgraficos.list.AnimalAdapter

class PersonListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_list)

        val listRvP = findViewById<RecyclerView>(R.id.rvPersons)
        val data = listOf(
            PersonEntity("John","Travolta","w1"),
            PersonEntity("Steven","Strange","w2"),
            PersonEntity("Peter","Parker","w3"),
            PersonEntity("Mary","Jane","w4"),
            PersonEntity("Clark","Kent","w5"),
            PersonEntity("Julio","Jaramillo","w6"),
            PersonEntity("Juan","Mecanico",""),
        )
        val adapter = PersonAdapter(data)
        // Reasigne the adapter to the RecyclerView
        listRvP.adapter = adapter

        listRvP.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        listRvP.layoutManager = GridLayoutManager(this,2)

    }
}