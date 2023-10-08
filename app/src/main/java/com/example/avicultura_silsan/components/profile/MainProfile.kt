package com.example.avicultura_silsan.components.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.avicultura_silsan.R
import com.example.avicultura_silsan.universal.ButtonDefault

@Preview
@Composable
fun MainProfile() {
    Column(
        modifier = Modifier
            .height(500.dp),
        verticalArrangement = Arrangement.spacedBy(50.dp)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            text = "Informações do Usuário",
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.intermedium)),
                fontWeight = FontWeight(600),
                color = Color(0xFFAA6231),
            ),
            textAlign = TextAlign.Start
        )
        FormProfile()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(115.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ButtonDefault(text = "Trocar Senha", color = 0xB2FD7A05) {}
            ButtonDefault(text = "Editar Conta", color = 0xFFFF5C00) {}
        }
    }
}