package com.example.avicultura_silsan.modal

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.avicultura_silsan.R
import com.example.avicultura_silsan.view_model.AnuncioViewModel

//@Preview
@Composable
fun ModalCupomAnuncio(
    isDialogVisibleCupom: Boolean,
    navController: NavController,
    viewModel: AnuncioViewModel
) {

    val startColor = Color(1.0f, 0.36f, 0.0f, 1.0f) // RGB: 255, 92, 0, 100%
    val endColor = Color(1.0f, 0.48f, 0.19f, 1.0f) // RGB: 255, 123, 49, 100%

    val clipboardManager = LocalClipboardManager.current
    var copiadoComSucesso by remember { mutableStateOf(false) }

    val precoOriginal = viewModel.precoOriginal
    val precoDesconto = viewModel.precoDesconto
    val cupom = viewModel.cupom

    val valor = NumberWithDecimalLimit(number = precoOriginal - precoDesconto, decimalPlaces = 2)
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Dialog(
            onDismissRequest = {
                isDialogVisibleCupom
            }
        ) {
            Column(
                modifier = Modifier
                    .width(340.dp)
                    .height(200.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(
                        Brush.verticalGradient(listOf(startColor, endColor))
                    ),
                verticalArrangement = Arrangement.spacedBy(2.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_close),
                        contentDescription = "",
                        modifier = Modifier
                            .size(22.dp)
                            .clickable { navController.navigate("anuncio") },
                    )
                }
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp, 0.dp),
                    verticalArrangement = Arrangement.spacedBy(35.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        text = "Resgate o cupom do seu produto na loja e ganhe: R$${valor} de desconto",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.intermedium)),
                            fontWeight = FontWeight(700),
                            color = Color(0xFFFFFFFF),
                            textAlign = TextAlign.Center,
                        )
                    )

                    Button(
                        modifier = Modifier
                            .width(170.dp)
                            .height(40.dp),
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(Color(0xFFFFFFFF))
                    ) {
                        Row (
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = cupom,
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily(Font(R.font.intermedium)),
                                    fontWeight = FontWeight(700),
                                    color = Color(0xFF000000),
                                )
                            )

                            Image(
                                painter = painterResource(id = R.drawable.icon_copy),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(24.dp)
                                    .clickable {
                                        clipboardManager.setText(AnnotatedString("IB85NHJ"))
                                    }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun NumberWithDecimalLimit(number: Double, decimalPlaces: Int): String {
    val formattedNumber = String.format("%.${decimalPlaces}f", number)

    return formattedNumber
}