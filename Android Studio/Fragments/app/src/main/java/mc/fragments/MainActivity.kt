package mc.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import mc.fragments.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity(),InicioFragment.ActivarContenedor, CalculoFragment.CambiarPregunta {
    val enlace: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    lateinit var fragment:Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(enlace.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.salir ->{
                //TODO
            }
            R.id.informacion ->{
                findNavController(enlace.contenedorArriba.id).navigate(R.id.action_inicioFragment_to_infoFragment)
                desactivar()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun activador() {
        enlace.contenedorAbajo.visibility = View.VISIBLE
    }

    override fun desactivar() {
        enlace.contenedorAbajo.visibility = View.GONE
    }

    override fun cambiaFragments() {
        var frag = Random.nextInt(2)
        if (frag == 1){
            fragment = CalculoFragment()
        }else{
            fragment = PreguntaFragment()
        }
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.contenedor_abajo,fragment)
            .commit()
    }
}




