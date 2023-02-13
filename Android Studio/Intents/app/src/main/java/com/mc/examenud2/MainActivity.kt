package com.mc.examenud2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.google.gson.Gson
import com.mc.examenud2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val enlace:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var lista:ListView
    private var listaProveedor = ArrayList<Proveedor>()
    private lateinit var adaptador: ArrayAdapter<Proveedor>
    val gson = Gson()
    var ultima:Long=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(enlace.root)

        lista = enlace.listview
        adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1,listaProveedor)
        lista.adapter = adaptador

        val boton = enlace.floatingActionButton
        boton.setOnClickListener{
            val intento = Intent(this,NuevoActivity::class.java)
            intento.putExtra(ID,listaProveedor.size+1)
            lanzarActividad.launch(intento)
        }

        lista.setOnItemClickListener { _, _, posicion, _ ->
            val intento = Intent(this,DetalleActivity::class.java)
            val detalleProveedor = listaProveedor[posicion]
            val cadenaGson = gson.toJson(detalleProveedor)
            intento.putExtra(PROVEEDOR,cadenaGson)
            startActivity(intento)
        }
    }

    val lanzarActividad = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            resultado: ActivityResult ->
        if (resultado.resultCode == Activity.RESULT_OK) {
            val intento = resultado.data
            //val intentID = Intent(this,)
            intento?.let {
                adaptador.add(gson.fromJson(it.extras?.getString(PROVEEDOR),Proveedor::class.java))
                lista.adapter = adaptador
            }
        }
    }



    override fun onBackPressed() {
        val actual=System.currentTimeMillis()
        if((actual-ultima)<LAPSO){
            super.onBackPressed()
        }else{
            ultima=actual
            Toast.makeText(this, "Pulsa otra vez para salir", Toast.LENGTH_SHORT).show()
        }
    }
}