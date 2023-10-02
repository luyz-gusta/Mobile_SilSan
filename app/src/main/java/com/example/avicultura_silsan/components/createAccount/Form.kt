package com.example.avicultura_silsan.components.createAccount

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.avicultura_silsan.universal.TextBox

@Composable
fun Form (
    navController: NavController
){
    var nomeState by remember {
        mutableStateOf("")
    }

    var telefoneState by remember {
        mutableStateOf("")
    }

    var selectedDate by remember { mutableStateOf("") }

    var senhaState by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TextBox(
            label = "Nome",
            valor = nomeState,
            aoMudar = {
                nomeState = it
            }
        )

        TextBox(
            label = "Telefone",
            valor = telefoneState,
            aoMudar = {
                telefoneState = it
            }
        )

        OutlinedDate(
            selectedDate
        ) {
            selectedDate = it
        }
    }
}