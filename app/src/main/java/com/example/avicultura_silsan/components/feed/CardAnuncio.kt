package com.example.avicultura_silsan.components.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.avicultura_silsan.R


@Composable
fun CardAnuncio(
    nome: String,
    peso: Double,
    precoOriginal: Double,
    precoDesconto: Double,
    onClick: () -> Unit
    // imagem: String
) {
    Column(
        modifier = Modifier
            .width(360.dp)
            .height(180.dp)
            .background(Color.White)
            .border(
                width = 2.dp,
                color = Color(0xFFE9E9E9),
                shape = RoundedCornerShape(size = 8.dp)
            ),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Row(
            modifier = Modifier
                .width(300.dp)
                .height(80.dp)
                .padding(15.dp, 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.dogue),
                contentDescription = "Imagem Produto",
                modifier = Modifier
                    .height(80.dp)
                    .width(65.dp)
            )
//            AsyncImage(
//                model = "",
//                contentDescription = "Imagem Produto",
//                modifier = Modifier
//                    .height(80.dp)
//                    .width(65.dp)
//            )
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = nome,
                fontFamily = FontFamily(Font(R.font.glory_variable)),
                fontWeight = FontWeight(600),
                fontSize = 16.sp,
                color = colorResource(id = R.color.black)
            )
        }
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            //.width(295.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "${peso}kg",
                    fontFamily = FontFamily(Font(R.font.glory_variable)),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.black)
                )
                Text(
                    text = "Peso",
                    fontFamily = FontFamily(Font(R.font.glory_variable)),
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color(0xFFA1A0A0)
                )
            }

            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "R$ $precoOriginal",
                    fontFamily = FontFamily(Font(R.font.glory_variable)),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.black)
                )
                Text(
                    text = "Preço Inicial",
                    fontFamily = FontFamily(Font(R.font.glory_variable)),
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color(0xFFA1A0A0)
                )
            }

            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "R$ $precoDesconto",
                    fontFamily = FontFamily(Font(R.font.glory_variable)),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.black)
                )
                Text(
                    text = "Desconto",
                    fontFamily = FontFamily(Font(R.font.glory_variable)),
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color(0xFFA1A0A0)
                )
            }


        }
    }
}