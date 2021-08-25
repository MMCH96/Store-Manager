package com.example.catalogo2
import java.io.Serializable
data class Prenda(
    var idPrenda:Int,
    var nombre: String,
    var talla: String
    ) : Serializable