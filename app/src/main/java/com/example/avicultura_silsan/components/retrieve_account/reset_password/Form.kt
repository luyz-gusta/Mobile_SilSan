package com.example.avicultura_silsan.components.retrieve_account.reset_password

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.avicultura_silsan.components.login.TextFieldPassword
import com.example.avicultura_silsan.components.retrieve_account.insert_code.ButtonCode

@Preview
@Composable
fun FormResetPassword() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .padding(start = 12.dp),
        ) {
            Text(
                text = "Recuperação de senha",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(800),
                    color = Color(0xFF000000),
                )
            )

            Text(
                text = "Crie sua nova senha abaixo",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                )
            )
        }
        Column (
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TextFieldPassword(
                label = "Nova senha",
                valor = "passwordState",
                aoMudar = {
                    //onPasswordChange(it)
                }
            )
            TextFieldPassword(
                label = "Confirmar senha" ,
                valor = "confirmPasswordState",
                aoMudar ={
                    //onConfirmPasswordChange(it)
                }
            )
            ButtonPassword(
                text = "Redefinir senha",
                color = 0xFFFF5C00,
                colorText = 0xFFFFFFFF
            ) {}
        }

    }
}