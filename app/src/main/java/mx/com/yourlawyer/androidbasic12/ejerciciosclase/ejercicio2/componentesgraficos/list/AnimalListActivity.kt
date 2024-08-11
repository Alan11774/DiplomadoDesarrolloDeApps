package mx.com.yourlawyer.androidbasic12.ejerciciosclase.ejercicio2.componentesgraficos.list

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mx.com.yourlawyer.androidbasic12.R

class AnimalListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_animal_list)
        // listRvA is the RecyclerView component from the layout
        val listRvA = findViewById<RecyclerView>(R.id.rvAnimals)
       // data collection for the list of animals
        val data = listOf(
            AnimalEntity("Monkey","Brown","w1"),
            AnimalEntity("Dog","White","w2"),
            AnimalEntity("Horse","Brown","w3"),
            AnimalEntity("Lion","Yellow",""),
            AnimalEntity("Quetzal","Blue",""),
            AnimalEntity("Shark","Gray",""),
            AnimalEntity("Wolf","Black",""),
            AnimalEntity("Canary","Yellow",""),
        )
        // Create the adapter for the RecyclerView
        val adapter = AnimalAdapter(data)

        adapter.onItemSelected = { animal ->
            // Handle the click event on the list item
            // animal is the data of the clicked item
            // Here you can navigate to another activity or fragment
            // or show a dialog with the data of the clicked item
//            Toast.makeText(this, "You clicked on ${animal.name}", Toast.LENGTH_SHORT).show()

            // This will open the AnimalDetailedActivity
            val intent = Intent(this, AnimalDetailedActivity::class.java).apply {
                // KEYS ALWAYS IN CAPITAL LETTERS
                putExtra( "EXTRA_ANIMAL", animal)
            }
            startActivity(intent)
        }
        // Reasigne the adapter to the RecyclerView
        listRvA.adapter = adapter

        listRvA.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        listRvA.layoutManager = GridLayoutManager(this,2)

    }
}