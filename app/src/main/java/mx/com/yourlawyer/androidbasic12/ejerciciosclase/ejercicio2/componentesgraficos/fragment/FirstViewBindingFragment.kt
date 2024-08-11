package mx.com.yourlawyer.androidbasic12.ejerciciosclase.ejercicio2.componentesgraficos.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mx.com.yourlawyer.androidbasic12.R
import mx.com.yourlawyer.androidbasic12.databinding.FragmentFirstBinding

class FirstViewBindingFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNext.setOnClickListener { view ->
        parentFragmentManager.beginTransaction().replace(R.id.fragment, SecondFragment.newInstance())
            .addToBackStack("SecondFragment")
            .commit()
        }
    }
    companion object {
        @JvmStatic
        fun newInstance() = FirstViewBindingFragment()
    }
}