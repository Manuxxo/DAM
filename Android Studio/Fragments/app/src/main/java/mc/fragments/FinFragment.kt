package mc.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mc.fragments.databinding.FragmentInicioBinding



class FinFragment : Fragment() {
    lateinit var enlace:FragmentInicioBinding
    var contador=0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_primer, container, false)
        enlace= FragmentInicioBinding.inflate(inflater,container,false)//--------------(1)
        return enlace.root
    }

}
