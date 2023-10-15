package com.example.avicultura_silsan.service

import com.example.avicultura_silsan.view_model.RetrieveAccountViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

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

    fun postCadastroService(): CadastroService{
        return retrofitFactory.create(CadastroService::class.java)
    }

    fun getListProdutos(): FeedService{
        return retrofitFactory.create(FeedService::class.java)
    }

    fun retrieveAccount(): RetrieveAccountService{
        return retrofitFactory.create(RetrieveAccountService::class.java)
    }

}