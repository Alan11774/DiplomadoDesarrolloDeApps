package mx.com.yourlawyer.androidbasic12.tarea

import android.content.Intent
import android.os.Bundle
import android.service.autofill.Validators.and
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import mx.com.yourlawyer.androidbasic12.R

class AlanRegistroApp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alan_registro_app)

        val etName = findViewById<EditText>(R.id.etName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)
        val cbTerms = findViewById<CheckBox>(R.id.cbTerms)
        val btnSave = findViewById<Button>(R.id.btnSave)

        btnSave.setOnClickListener {
            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            val selectedGenderId = rgGender.checkedRadioButtonId
            val gender = findViewById<RadioButton>(selectedGenderId)?.text.toString()
            val termsAccepted = cbTerms.isChecked

            val userInfo = """
                Name: $name
                Email: $email
                Password: $password
                Gender: $gender
                Terms Accepted: $termsAccepted
            """

            if ((password.length >= 8) and (termsAccepted == true)) {
                val intent = Intent(this, ShowResults::class.java).apply {
                    putExtra("USER_INFO", userInfo)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Password must be at least 8 characters long", Toast.LENGTH_LONG).show()
            }
        }
    }
}