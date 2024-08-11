package mx.com.yourlawyer.androidbasic12.ejerciciosclase.ejercicio2.componentesgraficos

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mx.com.yourlawyer.androidbasic12.R

class ComponentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_components)

        val cbCreditCard = findViewById<CheckBox>(R.id.cbCreditCard)
        val btnGetInfo = findViewById<Button>(R.id.btnGetInfo)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val etName = findViewById<EditText>(R.id.etName)
        // Checkbox
        cbCreditCard.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                rgGender.visibility = View.GONE
            }else{
                rgGender.visibility = View.VISIBLE
            }
            Toast.makeText(this,"IsChecked",Toast.LENGTH_SHORT).show()
        }
        // Button
        btnGetInfo.setOnClickListener {
            val cbStatus = cbCreditCard.isChecked
            // Structure like if elif else in python
            val selectedRgOption = when(rgGender.checkedRadioButtonId){
                R.id.rbMan -> {
                    "H"
                }
                R.id.rbWoman -> {
                    "M"
                }
                else -> {
                    "Reptil"
                }
            }
            val itemSpinnerSelected = spinner.selectedItem
            if (etName.text.toString().isNotEmpty()){
                Toast.makeText(this,"is checked = $cbStatus and the user is $selectedRgOption Spinner is $itemSpinnerSelected and the name is ${etName.text.toString()}",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"You Must enter a name",Toast.LENGTH_SHORT).show()
            }
        }
        // Radiobutton
        rgGender.setOnCheckedChangeListener { radioGroup, id ->
            val idName = when(id){
                R.id.rbWoman -> {
                    "Woman"
                }
                R.id.rbMan -> {
                    "Man"
                }else -> {
                    "Maybe elle or reptilian"
                }
            }
            Toast.makeText(this,"User gender is  $idName",Toast.LENGTH_SHORT).show()
        }
        // Spinner
        val data = arrayOf("Mexico","Colombia","Argentina","Chile","Peru","EUA","Canada")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, data).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) // Is the animation when the spinner is clicked
        }
        spinner.adapter = adapter // Set the adapter to the spinner
        spinner.onItemSelectedListener = object :OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val itemselected = data[position]
                // In this case "this" is a ComponentActivity, because we are inside a object interface
                Toast.makeText(this@ComponentsActivity,"User selects $itemselected", Toast.LENGTH_LONG).show()
            }
            // Case when the user doesn't select anything
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@ComponentsActivity,"Nothing selected", Toast.LENGTH_LONG).show()
            }

        }

//        private fun getRbStatus(id: Int): String {
//
//        }
    }
}