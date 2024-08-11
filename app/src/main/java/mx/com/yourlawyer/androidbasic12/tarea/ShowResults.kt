package mx.com.yourlawyer.androidbasic12.tarea

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import mx.com.yourlawyer.androidbasic12.R

class ShowResults : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_results)

        val userInfo = intent.getStringExtra("USER_INFO")
        val tvResults = findViewById<TextView>(R.id.tvResultName)
        tvResults.text = userInfo
    }
}