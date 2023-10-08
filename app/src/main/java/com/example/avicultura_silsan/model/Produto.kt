package com.example.avicultura_silsan.model

data class Produto(
    val id: Int,
    val nome: String,
    val descricao: String,
    val peso: Double,
    val cupom: String,
    val url: String,
    val preco_desconto: Double,
    val preco_original: Double,
    val id_tipo_produto: Int,
    val tipo: String
)
