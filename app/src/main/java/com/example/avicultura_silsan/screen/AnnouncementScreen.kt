package com.example.avicultura_silsan.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.avicultura_silsan.R
import com.example.avicultura_silsan.components.announcement.ButtonCupom
import com.example.avicultura_silsan.components.announcement.Prices
import com.example.avicultura_silsan.components.announcement.ProductDescription
import com.example.avicultura_silsan.view_model.AnuncioViewModel

@Composable
fun AnnouncementScreen(
    navController: NavController,
    viewModel: AnuncioViewModel
) {

    val imagem = viewModel.foto
    val nome = viewModel.nome
    val peso = viewModel.peso
    val descricao =viewModel.descricao
    val precoOriginal = viewModel.precoOriginal
    val precoDesconto = viewModel.precoDesconto

    Column  (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(15.dp, 0.dp),
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(id = R.drawable.seta_voltar),
                contentDescription = "Voltar Feed",
                modifier = Modifier
                    .size(35.dp)
                    .clickable {
                        navController.navigate("feed")
                    }
            )
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(5.dp, 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(1){

                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp, 0.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(25.dp)
                ) {

//                    Image(
//                        painter = painterResource(id = R.drawable.racao),
//                        contentDescription = "Image Produto",
//                        modifier = Modifier
//                            .width(300.dp)
//                            .height(280.dp)
//                    )
                    AsyncImage(
                        model = imagem,
                        contentDescription = "Image Produto",
                        modifier = Modifier
                            .width(300.dp)
                            .height(280.dp)
                    )

                    Text(
                        text = "$nome - ${peso}kg",
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontFamily = FontFamily(Font(R.font.intermedium)),
                            fontWeight = FontWeight(700),
                            color = Color(0xFF000000),
                        )
                    )

                    Prices(
                        valorOriginal = precoOriginal,
                        valorDesconto = precoDesconto
                    )

                    ButtonCupom(){}
                    Spacer(modifier = Modifier.height(5.dp))
                    ProductDescription(descricao)
                    Spacer(modifier = Modifier.height(5.dp))
                }
            }
        }
    }

}