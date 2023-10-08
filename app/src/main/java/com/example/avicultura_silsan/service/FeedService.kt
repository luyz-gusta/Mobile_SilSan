package com.example.avicultura_silsan.service

import com.example.avicultura_silsan.model.Produto
import com.example.avicultura_silsan.model.ResponseProduto
import retrofit2.Call
import retrofit2.http.GET

interface FeedService {

    @GET("produto")
    fun getProdutos() : Call<ResponseProduto>
}