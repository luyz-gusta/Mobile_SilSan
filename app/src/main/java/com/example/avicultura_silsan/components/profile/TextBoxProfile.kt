package com.example.avicultura_silsan.components.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.avicultura_silsan.R

@Composable
fun TextBoxProfile(
    nomeValor: String,
    valor: String
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()//width.dp)
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = nomeValor,
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.intermedium)),
            fontWeight = FontWeight(500),
            color = Color(0xFF808080)
        )

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = valor,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.intermedium)),
                fontWeight = FontWeight(500),
                color = Color(0xFF455A64)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(color = Color(0xFFCECECE))
            )
        }
    }
}