package com.example.avicultura_silsan.components.retrieve_account.insert_code

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.avicultura_silsan.components.retrieve_account.insert_email.ButtonInsertEmail
import com.example.avicultura_silsan.universal.ButtonDefault

@Preview
@Composable
fun FormInsertCode() {
    var codigoState by remember {
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Informe o código de verificação",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight(800),
                color = Color(0xFF000000),
            )
        )
        Box(
            modifier = Modifier
                .width(240.dp)
                .height(50.dp)
        ){
            Text(
                text = "Agora, insira o código que enviamos por e-mail para criar uma nova senha.",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                )
            )
        }

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterHorizontally),

                ) {
                TextFieldCode(
                    "Codigo",
                    codigoState
                ) {
                    codigoState = it
                }
            }
            Spacer(modifier = Modifier.height(64.dp))
            ButtonCode(
                text = "Continuar",
                color = 0xFFFF5C00,
                colorText = 0xFFFFFFFF,
                onClick = { }
            )
            Spacer(modifier = Modifier.height(24.dp))

            ButtonCode(
                text = "Reenviar código",
                color = 0xFFE6E6E6,
                colorText = 0xFF808080,
            ) {
                
            }
        }
    }
}