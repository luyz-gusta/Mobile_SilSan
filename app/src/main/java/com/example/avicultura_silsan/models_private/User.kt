package com.example.avicultura_silsan.models_private

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_user")
data class User(
    @PrimaryKey val id_user: Long = 0,
    val id_cliente: Long = 0,
    val email: String = "",
    val senha: String = "",
    val nome: String = "",
    val telefone: String = "",
    val dataNascimento: String = ""
)
