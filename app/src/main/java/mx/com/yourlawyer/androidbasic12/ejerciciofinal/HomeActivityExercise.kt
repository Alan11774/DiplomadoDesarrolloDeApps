package mx.com.yourlawyer.androidbasic12.ejerciciofinal

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mx.com.yourlawyer.androidbasic12.R
import mx.com.yourlawyer.androidbasic12.databinding.ActivityHomeExerciseBinding

class HomeActivityExercise : AppCompatActivity() {
    private lateinit var binding : ActivityHomeExerciseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_exercise)

         binding = ActivityHomeExerciseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // binding.tvFinal.text = "Texto final"

//        binding.tvTitle.text = "Your Lawyer"
//        binding.btnSignIn.text = "Sign In"
//        binding.tvCreateAccount.text = "Not account yet? Create Account"

        supportFragmentManager.beginTransaction()
            .add(R.id.flHome, HomeToSignIn.newInstance())
            .commit()


    }
}