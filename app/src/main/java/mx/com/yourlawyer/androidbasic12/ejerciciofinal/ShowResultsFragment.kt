package mx.com.yourlawyer.androidbasic12.ejerciciofinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mx.com.yourlawyer.androidbasic12.R
import mx.com.yourlawyer.androidbasic12.databinding.FragmentShowResultsBinding


class ShowResultsFragment : Fragment() {
    private lateinit var binding: FragmentShowResultsBinding
    private var email: String? = null
    private var password: String? = null
    private val userDb = mutableMapOf(
        "alan@gmail.com" to "123456",
        "juan@hotmail.com" to "abcd",
        "pedro@gmail.com" to "987654"
    )


    // OnCreate receive the arguments from newInstance method and assign them to the variables email and password
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            email = it.getString("USER_EMAIL")
            password = it.getString("USER_PASSWORD")
        }
    }
    // OnCreateView inflate the layout for this fragment and return the root view of the binding object created
    // in the binding object we have the views of the layout and we can access them by using the binding object
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentShowResultsBinding.inflate(inflater, container, false)
        return binding.root
    }
// OnViewCreated show the email and password in the layout of the ShowResultsFragment
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val result = userDb[email.toString()]
    if (userDb[email.toString()] == password) {
        // If the email and password are in the userDb show a message that the user is welcome
        binding.tvInfo.text = "Welcome to the App $email"
        binding.tvEmailResult.text = "Your Email is : $email"
        binding.tvPasswordResult.text = "Your Password is: $password"
    }else if(userDb[email.toString()] != password && userDb[email.toString()] != null){
        // If the email is in the userDb but the password is not correct
        // show a message that the password is incorrect
        binding.tvInfo.text = "The Password is incorrect, please try again"
        binding.tvEmailResult.text = ""
        binding.tvPasswordResult.text = ""
    }else{
        // If the email is not in the userDb show a message that the user is not registered
        binding.tvInfo.text = "The User not registered, please create an account"
        binding.tvEmailResult.text = ""
        binding.tvPasswordResult.text = ""
        }

    }

    // Companion object to create a new instance of the fragment with the email and password arguments
    // and put them in a bundle and return the bundle to the newInstance method
    // and return the newInstance method to the onCreateView method in the HomeToSignIn fragment
    // and pass the bundle to the newInstance method in the HomeToSignIn fragment to create a new instance of the ShowResultsFragment
    // and pass the email and password to the newInstance method in the ShowResultsFragment to create a new instance of the ShowResultsFragment
    // and pass the email and password to the ShowResultsFragment to show the email and password in the layout of the ShowResultsFragment
    // and show the email and password in the layout of the HomeToSignIn fragment when the user click on the button SignIn
    companion object {
        @JvmStatic
        fun newInstance(email: String, password: String) = ShowResultsFragment().apply {
            arguments = Bundle().apply{
                putString("USER_EMAIL", email)
                putString("USER_PASSWORD", password)
            }
        }

    }
}