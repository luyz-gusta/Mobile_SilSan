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
    nome:String,
    telefone:String,
    dataNascimento:String,
    email:String,
    senha:String,
    cofirmaSenha:String,
    onNomeChange:(String) -> Unit,
    onTelefoneChange:(String) -> Unit,
    onDataNascimentoChange:(String) -> Unit,
    onEmailChange:(String) -> Unit,
    onSenhaChange:(String) -> Unit,
    onConfirmaSenhaChange:(String) -> Unit,
){
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextBox(
            label = "Nome",
            valor = nome,
            aoMudar = {
                onNomeChange(it)
            }
        )

        TextBox(
            label = "Telefone",
            valor = telefone,
            aoMudar = {
                onTelefoneChange(it)
            }
        )

        OutlinedDate(
            dataNascimento
        ) {
            onDataNascimentoChange(it)
        }

        TextBox(
            label = "Email",
            valor = email,
            aoMudar = {
                onEmailChange(it)
            }
        )

        TextFieldPasswordCreateAccount(
            label = "Senha",
            valor = senha,
            aoMudar = {
                onSenhaChange(it) // Chame a função de callback para atualizar a senha
            }
        )

        TextFieldPasswordCreateAccount(
            label = "Confirme a senha",
            valor = cofirmaSenha,
            aoMudar = {
                onConfirmaSenhaChange(it)// Chame a função de callback para atualizar a senha
            }
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Preview() {
}