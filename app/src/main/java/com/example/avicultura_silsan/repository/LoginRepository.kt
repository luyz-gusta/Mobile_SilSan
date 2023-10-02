package com.example.avicultura_silsan.repository

import com.example.avicultura_silsan.service.RetrofitHelper
import com.google.gson.JsonObject
import retrofit2.Response

class LoginRepository {

    private val apiService = RetrofitHelper.postLoginService()

    suspend fun loginUsuario(email: String, senha: String): Response<JsonObject>{
        val requestBody = JsonObject().apply {
            addProperty("email", email)
            addProperty("senha", senha)
        }

        return apiService.loginUsuario(requestBody)
    }
}