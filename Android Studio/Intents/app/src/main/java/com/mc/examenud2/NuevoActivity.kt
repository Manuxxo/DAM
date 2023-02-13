package com.mc.examenud2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.mc.examenud2.databinding.ActivityNuevoBinding

class NuevoActivity : AppCompatActivity() {
    val enlace: ActivityNuevoBinding by lazy {
        ActivityNuevoBinding.inflate(layoutInflater)
    }

    val gson= Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(enlace.root)

        val botonSalir = enlace.botonSalir
        val botonOk = enlace.botonOK
        val extras = intent.extras
        extras?.let {
            enlace.txtId.text = "${it.getInt(ID)}"
        }

        botonOk.setOnClickListener{
            if (enlace.editNombre.text.isNullOrBlank() || enlace.editEmail.text.isNullOrBlank() || enlace.editDireccion.text.isNullOrBlank()){
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }else{
                val proveedor = Proveedor(enlace.editNombre.text.toString(),enlace.editEmail.text.toString(),enlace.editDireccion.text.toString())
                val resultadoIntent = Intent()
                val cadenaJson = gson.toJson(proveedor)
                resultadoIntent.putExtra(PROVEEDOR, cadenaJson)
                setResult(Activity.RESULT_OK, resultadoIntent)
                finish()
            }
        }

        botonSalir.setOnClickListener{
            finish()
        }
    }

    override fun onBackPressed() {
        Toast.makeText(this, "Sólo puedes volver si cancelas", Toast.LENGTH_SHORT).show()
    }
}