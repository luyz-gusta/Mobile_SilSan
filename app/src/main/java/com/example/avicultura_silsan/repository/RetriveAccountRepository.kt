package com.example.avicultura_silsan.repository

import com.example.avicultura_silsan.service.RetrofitHelper
import com.google.gson.JsonObject
import retrofit2.Response

class RetriveAccountRepository {

    private val apiService = RetrofitHelper.retrieveAccount()

    suspend fun insertEmail(email: String): Response<JsonObject> {
        val requestBody = JsonObject().apply {
            addProperty("email", email)
        }

        return apiService.postInsertEmail(requestBody)
    }

    suspend fun validateToken(email: String?, token: Int?): Response<JsonObject> {
        val requestBody = JsonObject().apply {
            addProperty("email", email)
            addProperty("token", token)
        }

        return apiService.postValidateToken(requestBody)
    }

}