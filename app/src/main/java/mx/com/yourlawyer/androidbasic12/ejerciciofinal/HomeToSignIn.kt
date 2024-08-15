package mx.com.yourlawyer.androidbasic12.ejerciciofinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import mx.com.yourlawyer.androidbasic12.R
import mx.com.yourlawyer.androidbasic12.databinding.FragmentHomeToSignInBinding

class HomeToSignIn : Fragment() {
    private lateinit var binding: FragmentHomeToSignInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeToSignInBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        binding.btnSignIn.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            if (email.isNotEmpty()){
                parentFragmentManager.beginTransaction()
                    .replace(R.id.flHome, ShowResultsFragment.newInstance(email, password))
                    .addToBackStack("ShowResultsFragment").commit()
            }

//            val intent = Intent(requireActivity(), HomeActivity::class.java)
//            startActivity(intent)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeToSignIn()
    }
}