package com.example.avicultura_silsan.functions

import android.content.Context
import com.example.avicultura_silsan.models_private.User
import com.example.avicultura_silsan.sqlite_repository.UserRepository

fun saveLogin(
    context: Context,
    id_user: Int,
    id_client: Int,
    email: String,
    senha: String,
    nome: String,
    telefone: String,
    dataNascimento: String
):Long{
    val newUser = User(
        id_user = id_user.toLong(),
        id_cliente = id_client.toLong(),
        email = email,
        senha = senha,
        nome = nome,
        telefone,
        dataNascimento
    )

    return UserRepository(context).save(newUser)
}

fun deleteUserSQLite(context: Context): Int{
    return UserRepository(context).deleteAllUser()
}
