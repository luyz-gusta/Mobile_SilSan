package com.example.avicultura_silsan.components.feed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.avicultura_silsan.R
import com.example.avicultura_silsan.view_model.AnuncioViewModel

@Composable
fun ListCard(
    navController: NavController,
    viewModel: AnuncioViewModel
) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp, 0.dp)
    ) {
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Anúncios",
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.glory_variable)),
            fontWeight = FontWeight(600),
            color = Color(0xFF585858),
        )
        Spacer(
            modifier = Modifier.height(28.dp)
        )
        LazyColumn{
            items(6){
                CardAnuncio(
                    nome = "Ração Cachorro - Special Dog adulto",
                    peso = 15.0,
                    precoOriginal = 280.55,
                    precoDesconto = 259.99,
                    {
                        navController.navigate("anuncio")
                    }
                )
                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }
}