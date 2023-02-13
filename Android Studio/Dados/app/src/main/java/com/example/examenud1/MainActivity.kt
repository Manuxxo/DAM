package com.example.examenud1

import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.KeyEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import com.example.examenud1.databinding.ActivityMainBinding
import java.util.Collections.rotate
import java.util.Locale
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    lateinit var imagenDado: ImageView
    private var numeroTiradas:Int = 1

    private val enlace: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(enlace.root)

        //Hago el textView donde muestro las tiras de tipo scroll
        enlace.txtResultado.movementMethod = ScrollingMovementMethod()

        //Detecto el enter

        enlace.txtEntradaNombre.setOnClickListener{
            detectarEnter()
        }

        //Muestro la barra y el botón si está seleccionado
        enlace.tbtnActivar.setOnCheckedChangeListener{_, isChecked ->
            if (isChecked) {
                enlace.barraFuerza.visibility = View.VISIBLE
                enlace.btnLanzar.visibility = View.VISIBLE
            } else {
                restart()
            }
        }
        //Lanzo el dado
        enlace.btnLanzar.setOnClickListener{
            rotarDado(enlace.barraFuerza.progress)
        }
    }

    private fun detectarEnter(){
        //Cuando se pulsa una tecla, detecto si es un enter y si está vacío o es nullo
        enlace.txtEntradaNombre.setOnKeyListener(View.OnKeyListener { _, i, keyEvent ->
            if (i == KeyEvent.KEYCODE_ENTER && keyEvent.action == KeyEvent.ACTION_UP && !(enlace.txtEntradaNombre.text.toString().isNullOrBlank())){
                enlace.txtNombre.text = enlace.txtEntradaNombre.text
                enlace.txtEntradaNombre.visibility = View.INVISIBLE
                enlace.txtNombre.visibility = View.VISIBLE
                enlace.tbtnActivar.visibility = View.VISIBLE
                return@OnKeyListener true
            }
            false
        })
    }

    private fun restart(){

        //Reinicio tod0 para que se muestre como el inicio
        enlace.txtEntradaNombre.text = null
        enlace.txtEntradaNombre.visibility = View.VISIBLE
        enlace.txtNombre.visibility = View.INVISIBLE
        enlace.tbtnActivar.visibility = View.INVISIBLE
        enlace.barraFuerza.visibility = View.INVISIBLE
        enlace.btnLanzar.visibility = View.INVISIBLE
        enlace.txtResultado.visibility = View.INVISIBLE
        enlace.imgDados.visibility = View.INVISIBLE
        enlace.txtResultado.visibility = View.INVISIBLE

        numeroTiradas = 1
        enlace.txtResultado.text = ""
    }


    private fun rotarDado(fuerza:Int){

        var potencia = fuerza
        //Creo la animación
        var animacion: Animation = AnimationUtils.loadAnimation(this,R.anim.rotacion)
        var i:Int
        //Muestro la imagen y el resultado
        enlace.imgDados.visibility = View.VISIBLE
        enlace.txtResultado.visibility = View.VISIBLE


        imagenDado = enlace.imgDados
        animacion.repeatCount = potencia //no consigo hacer que se repita la animacion
        imagenDado.startAnimation(animacion) //Empiezo la animacion

        do{
            i = Random.nextInt(6)+1
            //Muestro la imagen dependiento lo que haya tocado
            when(i){
                1 -> imagenDado.setImageResource(R.drawable.dado1)
                2 -> imagenDado.setImageResource(R.drawable.dado2)
                3 -> imagenDado.setImageResource(R.drawable.dado3)
                4 -> imagenDado.setImageResource(R.drawable.dado4)
                5 -> imagenDado.setImageResource(R.drawable.dado5)
                6 -> imagenDado.setImageResource(R.drawable.dado6)
            }
        }while(potencia-- > 0)
        //Muestro el resultado
        var idioma = Locale.getDefault().displayLanguage
        if(idioma == "español"){
            enlace.txtResultado.append("Tirada $numeroTiradas -> $i\n")
        }else{
            enlace.txtResultado.append("Round $numeroTiradas -> $i\n ")
        }
        numeroTiradas++
    }


}