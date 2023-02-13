package com.mc.examenud2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.mc.examenud2.databinding.ActivityDetalleBinding

class DetalleActivity : AppCompatActivity() {

    val gson = Gson()

    val enlace: ActivityDetalleBinding by lazy {
        ActivityDetalleBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(enlace.root)

        val extras = intent.extras
        var detalleProveedor:Proveedor
        var email = ""
        var direccion = ""

        extras?.let {
            detalleProveedor = gson.fromJson(it.getString(PROVEEDOR),Proveedor::class.java)
            enlace.txtId.text = detalleProveedor.id.toString()
            enlace.txtNombre.text = detalleProveedor.nombre
            enlace.txtEmail.text = detalleProveedor.email
            enlace.txtDireccion.text = detalleProveedor.direccion
            email = detalleProveedor.email
            direccion = detalleProveedor.direccion
        }

        enlace.btnMap.setOnClickListener{
            val uri = Uri.parse("geo:0,0?q=$direccion")
            val mapaIntento = Intent(Intent.ACTION_VIEW, uri)
            startActivity(mapaIntento)
        }

        enlace.btnEmail.setOnClickListener{
            val emailIntento = Intent(Intent.ACTION_SENDTO)
            emailIntento.data = Uri.parse("mailto:$email" )
            emailIntento.putExtra(Intent.EXTRA_SUBJECT, "Hola!");
            startActivity(emailIntento)
        }
    }
}