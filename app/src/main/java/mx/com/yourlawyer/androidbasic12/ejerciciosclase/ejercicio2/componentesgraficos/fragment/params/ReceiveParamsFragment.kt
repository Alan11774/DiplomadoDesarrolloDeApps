package mx.com.yourlawyer.androidbasic12.ejerciciosclase.ejercicio2.componentesgraficos.fragment.params

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mx.com.yourlawyer.androidbasic12.R
import mx.com.yourlawyer.androidbasic12.databinding.FragmentReceiveParamsBinding


class ReceiveParamsFragment : Fragment() {


    private lateinit var binding: FragmentReceiveParamsBinding
    private var name: String? = ""
    private var age: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString("ARG_NAME")
            age = it.getInt("ARG_AGE")

            println("Name: $name, Age: $age")
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReceiveParamsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvReceiveParams.text = "Name: $name, Age: $age"
    }


    companion object {
        @JvmStatic
        fun newInstance(name: String, age: Int) = ReceiveParamsFragment().apply {
            arguments = Bundle()?.apply {
                putString("ARG_NAME", name)
                putInt("ARG_AGE", age)
            }
        }
    }
}