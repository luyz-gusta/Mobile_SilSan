package com.example.avicultura_silsan.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    private const val baseURL = "https://avicultura-silsa-api.cyclic.app/v1/avicultura-silsan/"

    private val retrofitFactory =
        Retrofit.Builder().
        baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun postLoginService(): LoginService{
        return retrofitFactory.create(LoginService::class.java)
    }

}