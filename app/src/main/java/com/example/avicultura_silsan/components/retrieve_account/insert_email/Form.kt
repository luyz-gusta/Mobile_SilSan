package com.example.avicultura_silsan.components.retrieve_account.insert_email

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.avicultura_silsan.R

@Composable
fun FormInsertEmail(
    emailState: String,
    onEmailChange: (String) -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 0.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            modifier = Modifier
                .width(210.dp),
            text = "Esqueci minha senha",
            style = TextStyle(
                fontSize = 32.sp,
                fontFamily = FontFamily(Font(R.font.intermedium)),
                fontWeight = FontWeight(400),
                color = Color(0xFFAA6231)
            )
        )
        
        Spacer(modifier = Modifier.height(40.dp))

        Box(
            modifier = Modifier
                .width(280.dp)
                .height(50.dp)
        ){
            Text(
                text = "Prezado cliente, digitar seu email para recuperação de senha",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                )
            )
        }

        TextBoxInsertEmail(
            label = "Email",
            valor = emailState,
            aoMudar = {
                onEmailChange(it)
            }
        )
    }
}