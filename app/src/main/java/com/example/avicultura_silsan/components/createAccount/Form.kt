package com.example.avicultura_silsan.components.createAccount

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.avicultura_silsan.components.login.TextFieldPassword
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

    var emailState by remember {
        mutableStateOf("")
    }

    var selectedDate by remember { mutableStateOf("") }

    var senhaState by remember {
        mutableStateOf("")
    }

    var confirmeSenhaState by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally
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

        TextBox(
            label = "Email",
            valor = nomeState,
            aoMudar = {
                nomeState = it
            }
        )

        TextFieldPasswordCreateAccount(
            label = "Senha",
            valor = senhaState,
            aoMudar = {
                senhaState = it // Chame a função de callback para atualizar a senha
            }
        )

        TextFieldPasswordCreateAccount(
            label = "Confirme a senha",
            valor = confirmeSenhaState,
            aoMudar = {
                confirmeSenhaState = it// Chame a função de callback para atualizar a senha
            }
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Preview() {
    val navController = rememberNavController()

    Form(navController = navController)
}