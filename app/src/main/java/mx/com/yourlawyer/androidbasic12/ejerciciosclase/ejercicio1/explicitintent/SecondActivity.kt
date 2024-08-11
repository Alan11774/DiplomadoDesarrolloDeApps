package mx.com.yourlawyer.androidbasic12.ejerciciosclase.ejercicio1.explicitintent

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mx.com.yourlawyer.androidbasic12.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val labelName = findViewById<TextView>(R.id.labelName)
        val btnReturn = findViewById<Button>(R.id.btnReturn)
        // Enable Edge to Edge in the activity layout
        supportActionBar?.setDisplayShowTitleEnabled(false)
        // Enable Edge to Edge in the activity layout
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        // Get the extras defined in HomeActivity and the simbol ? is used to avoid null pointer exception
        val name = intent.extras?.let {
            if (it.containsKey("EXTRA_NAME_KEY")){
                val name = it.getString("EXTRA_NAME_KEY", "")
                labelName.text = name
//                Toast.makeText(this, "My name is: $name", Toast.LENGTH_SHORT).show()
            }
            if (it.containsKey("EXTRA_AGE_KEY")) {
                val age = it?.getInt("EXTRA_AGE_KEY", 0)
                Toast.makeText(this,"My age is: $age", Toast.LENGTH_LONG).show()
            }

//            val surname = it?.getString("EXTRA_SURNAME", "")

//            Toast.makeText(this,"My age is: $age and my Surname is : $surname", Toast.LENGTH_LONG).show()
            btnReturn.setOnClickListener {
                val resultIntent = Intent().apply {
                    putExtra("EXTRA_IS_CORRECT_KEY", true)
                }
                setResult(RESULT_OK, resultIntent)
                finish()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            // ID for the back button
            android.R.id.home ->{
                onBackPressedDispatcher.onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}