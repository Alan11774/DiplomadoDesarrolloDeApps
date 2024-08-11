package mx.com.yourlawyer.androidbasic12.ejerciciosclase.ejercicio1

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mx.com.yourlawyer.androidbasic12.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.e("Lifecicle", "On Create")
        Toast.makeText(this , "onCreate",Toast.LENGTH_LONG).show()
    }

    override fun onStart() {
        super.onStart()
        Log.e("Lifecicle", "On Start")
        Toast.makeText(this , "OnStart",Toast.LENGTH_LONG).show()

    }

    override fun onResume() {
        super.onResume()
        Log.e("Lifecicle", "On Resume")
        Toast.makeText(this , "OnResume",Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()
        Log.e("Lifecicle", "On Pause")
        Toast.makeText(this , "OnPause",Toast.LENGTH_LONG).show()
    }

    override fun onStop() {
        super.onStop()
        Log.e("Lifecicle", "On Stop")
        Toast.makeText(this , "OnStop",Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Lifecicle", "On Destroy")
        Toast.makeText(this , "OnDestroy",Toast.LENGTH_LONG).show()
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("Lifecicle", "On Restart")
        Toast.makeText(this , "OnRestart",Toast.LENGTH_LONG).show()
    }
}