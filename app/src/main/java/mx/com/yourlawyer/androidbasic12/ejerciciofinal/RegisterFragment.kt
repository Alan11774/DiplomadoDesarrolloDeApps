package mx.com.yourlawyer.androidbasic12.ejerciciofinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mx.com.yourlawyer.androidbasic12.R
import mx.com.yourlawyer.androidbasic12.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {
    private lateinit var binding : FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            val newUser = true

            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()){
                parentFragmentManager.beginTransaction()
                    .replace(R.id.flHome, ShowResultsFragment.newInstance(email, password, newUser))
                    .addToBackStack("ShowResultsFragment").commit()
            }
        }
    }
    companion object {
        @JvmStatic
        fun newInstance() = RegisterFragment()
    }
}