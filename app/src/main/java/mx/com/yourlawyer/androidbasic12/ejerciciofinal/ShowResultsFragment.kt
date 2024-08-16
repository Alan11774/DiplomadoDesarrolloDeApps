package mx.com.yourlawyer.androidbasic12.ejerciciofinal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mx.com.yourlawyer.androidbasic12.databinding.FragmentShowResultsBinding
import androidx.cardview.widget.CardView


class ShowResultsFragment : Fragment() {
    private lateinit var binding: FragmentShowResultsBinding
    private var email: String? = null
    private var password: String? = null
    private var newUser: Boolean = false
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
            newUser = it.getBoolean("NEW_USER")
        }
    }

    // OnCreateView inflate the layout for this fragment and return the root view of the binding object created
    // in the binding object we have the views of the layout and we can access them by using the binding object
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShowResultsBinding.inflate(inflater, container, false)
        return binding.root
    }

    // OnViewCreated show the email and password in the layout of the ShowResultsFragment
// and manage the visibility of the images and text based on the user's input
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val result = userDb[email.toString()]
        if (userDb[email.toString()] == password || newUser) {
            // Mostrar las vistas correspondientes cuando el usuario es nuevo o las credenciales coinciden
            binding.cardEmailResult.visibility = View.VISIBLE
            binding.cardPasswordResult.visibility = View.VISIBLE
            binding.imageWelcome.visibility = View.VISIBLE
            binding.imageMew.visibility = View.VISIBLE

            // Configurar los textos de las etiquetas
            binding.tvEmailResult.text = "Your Email is: $email"
            binding.tvPasswordResult.text = "Your Password is: $password"

            // Ocultar el mensaje de error si lo hubiera
            binding.cardErrorMessage.visibility = View.GONE
            binding.imageErrorMew.visibility = View.GONE
            binding.cardUnregisteredUser.visibility = View.GONE
            binding.imageUnregisteredMiu.visibility = View.GONE
        } else if (userDb[email.toString()] != password && userDb[email.toString()] != null) {
            // Mostrar el mensaje de error si la contraseña es incorrecta y ocultar las otras vistas
            binding.cardErrorMessage.visibility = View.VISIBLE
            binding.imageErrorMew.visibility = View.VISIBLE
            binding.tvErrorMessage.text = "The Password is incorrect, please try again"

            binding.cardEmailResult.visibility = View.GONE
            binding.cardPasswordResult.visibility = View.GONE
            binding.imageWelcome.visibility = View.GONE
            binding.imageMew.visibility = View.GONE
            binding.cardUnregisteredUser.visibility = View.GONE
            binding.imageUnregisteredMiu.visibility = View.GONE
        } else {
            // Mostrar el mensaje de error si el usuario no está registrado
            binding.cardUnregisteredUser.visibility = View.VISIBLE
            binding.imageUnregisteredMiu.visibility = View.VISIBLE
            binding.tvUnregisteredUser.text = "The User is not registered, please create an account"

            binding.cardEmailResult.visibility = View.GONE
            binding.cardPasswordResult.visibility = View.GONE
            binding.imageWelcome.visibility = View.GONE
            binding.imageMew.visibility = View.GONE
            binding.cardErrorMessage.visibility = View.GONE
            binding.imageErrorMew.visibility = View.GONE
        }
    }

    // Companion object para crear una nueva instancia del fragment con los argumentos de correo y contraseña
    companion object {
        @JvmStatic
        fun newInstance(email: String, password: String, newUser: Boolean = false) =
            ShowResultsFragment().apply {
                arguments = Bundle().apply {
                    putString("USER_EMAIL", email)
                    putString("USER_PASSWORD", password)
                    putBoolean("NEW_USER", newUser)
                }
            }
    }
}