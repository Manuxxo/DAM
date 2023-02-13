package com.mc.examenud2

class Proveedor (nombre: String, email: String, direccion: String){

    val id:Int = nextId()
    var nombre:String
    var email:String
    var direccion:String

    init {
        this.nombre = nombre
        this.email = email
        this.direccion = direccion
    }

    private companion object{
        private var contadorID = 1
        private fun nextId(): Int {
            return contadorID++
        }
    }

    override fun toString(): String {
        return "\t\t\t$id\t\t\t       \t$nombre"
    }
}