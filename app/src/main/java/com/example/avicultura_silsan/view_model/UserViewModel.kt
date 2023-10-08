package com.example.avicultura_silsan.view_model

import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    var id_cliente: Int = 0
    var nome: String = ""
    var telefone: String = ""
    var data_nascimento: String = ""

    var id_usuario: Int = 0
    var email: String = ""
    var senha: String = ""

    var id_status_usuario: Int = 0
}