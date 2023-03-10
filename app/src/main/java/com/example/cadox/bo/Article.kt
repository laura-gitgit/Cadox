package com.example.cadox.bo

import java.time.LocalDate

data class Article (val id: Long,
                    val intitule: String,
                    val description: String,
                    val prix: Double,
                    val niveau: Byte,
                    var url: String? = null,
                    var achete: Boolean = false,
                    var dateAchat: LocalDate? = null){


    override fun toString(): String {
        return """"Article(id=$id, intitule='$intitule', description='$description', prix=$prix, 
                niveau=$niveau, url='$url', achete=$achete, dateAchat=$dateAchat)"""
    }

}