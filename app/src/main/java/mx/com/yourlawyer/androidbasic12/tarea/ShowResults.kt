package mx.com.yourlawyer.androidbasic12.tarea

import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import mx.com.yourlawyer.androidbasic12.R

class ShowResults : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_results)
        // Initialize the views from the layout
        val tvResults = findViewById<TextView>(R.id.tvResultName)
        val ivUserImage = findViewById<ImageView>(R.id.ivProfile)
        // Get data from previous activity
        val userInfo = intent.getStringExtra("USER_INFO")
        val userImageUri = intent.getStringExtra("USER_IMAGE")
        // Set the data to the views , first the text
        // then the image
        tvResults.text = userInfo
        if (userImageUri != null) {
            ivUserImage.setImageURI(Uri.parse(userImageUri))
        }
    }
}