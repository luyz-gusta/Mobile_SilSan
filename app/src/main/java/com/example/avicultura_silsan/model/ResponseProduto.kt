package com.example.avicultura_silsan.model

data class ResponseProduto (
    val status: Int,
    val message: String,
    val itens: List<Produto>
)