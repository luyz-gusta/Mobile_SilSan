package com.example.avicultura_silsan.components.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.avicultura_silsan.R


@Composable
fun Form(
    email: String,
    senha: String,
    onEmailChange: (String) -> Unit,
    onSenhaChange: (String) -> Unit,
    navController: NavController?
) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TextBoxScreen(
            label = "Email",
            valor = email,
            aoMudar = {
                onEmailChange(it) // Chame a função de callback para atualizar o email
            }
        )
        TextFieldPassword(
            label = "Senha",
            valor = senha,
            aoMudar = {
                onSenhaChange(it) // Chame a função de callback para atualizar a senha
            }
        )

        Text(
            text = "Esqueci a senha",
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 45.dp)
                .clickable {
                    navController?.navigate("forgot_password")
                },
            color = colorResource(id = R.color.orange_creme),
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.h4.copy(
                shadow = Shadow(
                    offset = Offset(10f, 10f),
                    blurRadius = 30f
                ),
                fontSize = 20.sp
            )
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun FormPreview(){
    val navController = rememberNavController()

    var emailState by remember {
        mutableStateOf("")
    }
    var senhaState by remember {
        mutableStateOf("")
    }

    Form(
        emailState,
        senhaState,
        onEmailChange = { emailState = it },
        onSenhaChange = { senhaState = it },
        navController
    )
}