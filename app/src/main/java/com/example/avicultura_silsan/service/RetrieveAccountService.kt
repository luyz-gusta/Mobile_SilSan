package com.example.avicultura_silsan.service

import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT

interface RetrieveAccountService {

    @Headers("Content-Type: application/json")
    @POST("esqueci-senha")
    suspend fun postInsertEmail(@Body body: JsonObject): Response<JsonObject>

    @Headers("Content-Type: application/json")
    @POST("validar-token")
    suspend fun postValidateToken(@Body body: JsonObject): Response<JsonObject>

    @Headers("Content-Type: application/json")
    @PUT("trocar-senha")
    suspend fun putMudarSenha(@Body body: JsonObject): Response<JsonObject>

}