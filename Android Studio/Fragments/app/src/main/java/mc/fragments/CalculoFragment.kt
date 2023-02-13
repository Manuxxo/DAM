package mc.fragments

import android.content.Context
import android.os.Bundle
import android.service.notification.NotificationListenerService.RankingMap
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import mc.fragments.databinding.FragmentCalculoBinding
import mc.fragments.databinding.FragmentPreguntaBinding
import java.util.Random


class CalculoFragment : Fragment() {
    
    lateinit var enlace:FragmentCalculoBinding
    lateinit var cambia:CambiarPregunta


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        enlace= FragmentCalculoBinding.inflate(inflater,container,false)//--------------(1)
        return enlace.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        cambia = context as CambiarPregunta
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val max = 100


        var operacion = Random().nextInt(3)
        var numero1 = Random().nextInt(max)
        var numero2 = Random().nextInt(max)
        var resultado=0


        when (operacion){
            0 -> {
                if (numero1<numero2){
                    enlace.txtOperacion.text = "$numero2 - $numero1"
                    resultado = numero2 - numero1
                }
            }
            1 -> {
                enlace.txtOperacion.text = "$numero1 * $numero2"
                resultado = numero1 * numero2
            }

            2 -> {
                enlace.txtOperacion.text = "$numero1 + $numero2"
                resultado = numero1 + numero2
            }
        }
        enlace.boton.setOnClickListener(){
            if (enlace.txtResultado.text.toString() == resultado.toString()){
                Toast.makeText(this.context,"Correcto!",Toast.LENGTH_LONG).show()
                cambia.cambiaFragments()
            }else{
                Toast.makeText(this.context,"Incorrecto!",Toast.LENGTH_LONG).show()
                cambia.cambiaFragments()
            }
        }
    }

    interface CambiarPregunta{
        fun cambiaFragments()
    }
}