package mc.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mc.fragments.databinding.FragmentInicioBinding
import mc.fragments.databinding.FragmentPreguntaBinding


class PreguntaFragment : Fragment() {
    lateinit var enlace: FragmentPreguntaBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        enlace= FragmentPreguntaBinding.inflate(inflater,container,false)//--------------(1)
        return enlace.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}