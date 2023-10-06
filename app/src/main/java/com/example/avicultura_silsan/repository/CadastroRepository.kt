package com.example.avicultura_silsan.repository

import com.example.avicultura_silsan.service.RetrofitHelper
import com.google.gson.JsonObject
import retrofit2.Response

class CadastroRepository {

    private val apiService = RetrofitHelper.postCadastroService()

    suspend fun cadastroUsuario(
        nome: String,
        telefone: String,
        dataNascimento: String,
        email: String,
        senha: String,
        confirmasenha: String,

    ): Response<JsonObject> {
        val requestBody = JsonObject().apply {
            addProperty("nome", nome)
            addProperty("telefone", telefone)
            addProperty("data_nascimento", dataNascimento)
            addProperty("email", email)
            addProperty("senha", senha)
            addProperty("confirmasenha", confirmasenha)
        }

        return apiService.cadastroUsuario(requestBody)
    }
}