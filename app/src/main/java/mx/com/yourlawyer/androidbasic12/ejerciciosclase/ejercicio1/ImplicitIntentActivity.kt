package mx.com.yourlawyer.androidbasic12.ejerciciosclase.ejercicio1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mx.com.yourlawyer.androidbasic12.R
import mx.com.yourlawyer.androidbasic12.databinding.ActivityImplicitIntentBinding

class ImplicitIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_implicit_intent)

//        This will import the generated binding class for the activity
//        is an alternative to the findViewById method
//        ActivityImplicitIntentBinding

        // Examples for Implicit Intent
        val btnSent = findViewById<Button>(R.id.btnSend)
        val btnSentUrl = findViewById<Button>(R.id.btnSendUrl)
        btnSent.setOnClickListener(){
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_SUBJECT, "Aviso Urgente")
                putExtra(Intent.EXTRA_TEXT, "Estimado usuario, se le informa que su cuenta ha sido bloqueada, Este es un mensaje de prueba")
            }
            startActivity(Intent.createChooser(emailIntent,"Enviar email utilizando:"))
        }
        btnSentUrl.setOnClickListener(){
            val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            startActivity(Intent.createChooser(urlIntent,"Abrir URL usando:"))
            }

        }
    }