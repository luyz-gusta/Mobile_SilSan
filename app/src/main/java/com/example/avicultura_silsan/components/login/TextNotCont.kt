package com.example.avicultura_silsan.components.login

import com.example.avicultura_silsan.R
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun TextNotCont(
    navController: NavController
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(7.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally),

        ) {
        Text(
            text = "Não tem conta?",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFFFFFFFF),
            )
        )

        Text(
            text = "Cadastre-se aqui.",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight(600),
                color = colorResource(id = R.color.black),
                textDecoration = TextDecoration.Underline
            ),
            modifier = Modifier
                .clickable {
                    navController?.navigate("create_account")
                }
        )

    }
}


//Cadastre-se aqui.