package mc.fragments

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import mc.fragments.databinding.FragmentInicioBinding



class InicioFragment : Fragment() {
    lateinit var enlace: FragmentInicioBinding
    private lateinit var padre:ActivarContenedor

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_primer, container, false)
        enlace= FragmentInicioBinding.inflate(inflater,container,false)//--------------(1)
        return enlace.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        padre=context as ActivarContenedor
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        enlace.btnComenzar.setOnClickListener{
            findNavController().navigate(R.id.action_inicioFragment_to_marcadorFragment)
            padre.activador()

        }
    }
    interface ActivarContenedor{
        fun activador()
        fun desactivar()
    }
}

