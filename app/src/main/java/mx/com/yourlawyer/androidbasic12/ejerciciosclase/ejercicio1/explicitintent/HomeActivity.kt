package mx.com.yourlawyer.androidbasic12.ejerciciosclase.ejercicio1.explicitintent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mx.com.yourlawyer.androidbasic12.R

class HomeActivity : AppCompatActivity() {
    private val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        // resultCode is RESULT_OK if the user accepted the request
        // is obtained from the result object and the resultCode is compared with the RESULT_OK constant
        if (result.resultCode == RESULT_OK){
            val isCorrect = result.data?.getBooleanExtra("EXTRA_IS_CORRECT_KEY",false)
            if (isCorrect == true){
                Toast.makeText(this, "isCorrect True", Toast.LENGTH_SHORT).show()
                // onBackPressedDispatcher.onBackPressed() is used to simulate the back button
                onBackPressedDispatcher.onBackPressed()
            }else {
                Toast.makeText(this, "Error isCorrect is false", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportActionBar?.setDisplayShowTitleEnabled(false)

        val btnSendActivity = findViewById<Button>(R.id.btnSendActivity)
        btnSendActivity.setOnClickListener(){
            val extraBundle = Bundle().apply{
                putString("EXTRA_SURNAME", "Mendoza")
                putBoolean("EXTRA_MARRIED", false)
            }
            // Make intent Instance, pass the context "this" and declare the desired class with classname::class.java
            val intent = Intent(this, SecondActivity::class.java).apply{
                // To give values to another activity, we use the putExtra method
                putExtra("EXTRA_NAME_KEY","Alan Ulises")
                putExtra("EXTRA_AGE_KEY", 27)
                putExtra("EXTRA_MORE_INFO",extraBundle)
            }
//            register.launcn(intent)
            startActivity(intent)
        }
    }

}