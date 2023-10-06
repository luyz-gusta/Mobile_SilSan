package com.example.avicultura_silsan.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.avicultura_silsan.R
import java.time.format.TextStyle

@Preview
@Composable
fun AnnouncementScreen() {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp, 20.dp)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth()
        ){
            Image(
                painter = painterResource(id = R.drawable.arrow_back),
                contentDescription = "Seta voltar"
            )
        }
        Image(
            painter = painterResource(id = R.drawable.dogue),
            contentDescription = ""
        )
        Text(
            text = "Ração Cachorro - Special Dog adulto - 15kg",
            fontSize = 24.sp,
            fontFamily = FontFamily(Font(R.font.glory_variable)),
            fontWeight = FontWeight(700),
            color = Color(0xFF000000)
        )
        Column (
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "R$ 280,55",
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight(400),
                    color = Color(0xFFB4B4B4),
                    textAlign = TextAlign.Center,
                    textDecoration = TextDecoration.LineThrough,
                )
            )
        }

    }
}