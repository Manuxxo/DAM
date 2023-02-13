package mc.fragments

import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mc.fragments.databinding.FragmentMarcadorBinding


class MarcadorFragment : Fragment() {
    lateinit var enlace: FragmentMarcadorBinding
    lateinit var cuentaAtras:CountDownTimer
    var tiempoRestante:Int = 60


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        enlace = FragmentMarcadorBinding.inflate(inflater,container,false)
        return enlace.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cuentaAtras = object : CountDownTimer(tiempoRestante*1000L,1000L){
            override fun onTick(millisUntilFinished: Long) {
                tiempoRestante = millisUntilFinished.toInt() / 1000
                enlace.tiempo.text = tiempoRestante.toString()
            }
            override fun onFinish() {

            }
        }
        cuentaAtras.start()

    }

}