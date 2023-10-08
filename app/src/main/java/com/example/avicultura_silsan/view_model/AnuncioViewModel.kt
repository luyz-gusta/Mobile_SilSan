package com.example.avicultura_silsan.view_model

import androidx.lifecycle.ViewModel

class AnuncioViewModel: ViewModel() {
    var nome: String = ""
    var descricao: String = ""
    var foto: String = ""
    var peso: Double = 0.0
    var precoOriginal: Double = 0.0
    var precoDesconto: Double = 0.0
    var cupom: String = ""
}