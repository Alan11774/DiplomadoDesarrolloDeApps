package mx.com.yourlawyer.androidbasic12.ejerciciosclase.ejercicio2.componentesgraficos.fragment.params

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mx.com.yourlawyer.androidbasic12.R
import mx.com.yourlawyer.androidbasic12.databinding.FragmentReceiveParamsBinding
import mx.com.yourlawyer.androidbasic12.databinding.FragmentSendParamsBinding


class SendParamsFragment : Fragment() {

    private lateinit var binding: FragmentSendParamsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSendParamsBinding.inflate(inflater, container, false)
        return binding.root


        // On this fragment, we will send params to another fragment
        // We use parentFragmentManager to replace the current fragment with another fragment
        // The parameters for replace are the id of the fragment and the newInstance() method
        // We will use the method newInstance() to create a new instance of the fragment
//        binding.btnSendParams.setOnClickListener {
//            parentFragmentManager.beginTransaction().replace(R.id.fragment, ReceiveParamsFragment.newInstance()
//                .addToBackStack("ReceiveParamsFragment").commit()
//        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = SendParamsFragment()
    }
}