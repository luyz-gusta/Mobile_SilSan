package com.example.avicultura_silsan.service

import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
//import retrofit2.http.POST
import retrofit2.http.PUT

interface CadastroService {

    @Headers("Content-Type: application/json")
    @POST("Cadastro")
    suspend fun cadastroUsuario(@Body body: JsonObject): Response<JsonObject>

}