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
        senha: String
    ): Response<JsonObject> {
        val requestBody = JsonObject().apply {
            addProperty("email_usuario", email)
            addProperty("senha_usuario", senha)
            addProperty("nome_cliente", nome)
            addProperty("telefone_cliente", telefone)
            addProperty("data_nascimento_cliente", dataNascimento)
        }

        return apiService.cadastroUsuario(requestBody)
    }
}