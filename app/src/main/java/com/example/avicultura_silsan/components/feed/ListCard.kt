package com.example.avicultura_silsan.components.feed

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.avicultura_silsan.model.Produto
import com.example.avicultura_silsan.model.ResponseProduto
import com.example.avicultura_silsan.service.RetrofitHelper
import com.example.avicultura_silsan.view_model.AnuncioViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun ListCard(
    navController: NavController,
    viewModel: AnuncioViewModel,
    context: Context
) {
    var listaProdutos by remember {
        mutableStateOf(listOf<Produto>())
    }

    val call = RetrofitHelper.getListProdutos().getProdutos()

    call.enqueue(object: Callback<ResponseProduto> {
        override fun onResponse(call: Call<ResponseProduto>, response: Response<ResponseProduto>) {
            Log.e("FEED - SUCESS - ResponseBody", response.body().toString())
            Log.e("FEED - SUCESS - ResponseBodyItens", response.body()!!.itens.toString())

            listaProdutos = response.body()!!.itens
        }

        override fun onFailure(call: Call<ResponseProduto>, t: Throwable) {
            Log.e("FEED - ERROR", "$t")
        }
    })

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .height(620.dp)
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
            items(listaProdutos){
                CardAnuncio(
                    nome = it.nome,
                    peso = it.peso,
                    precoOriginal = it.preco_original,
                    precoDesconto = it.preco_desconto,
                    imagem = it.url,
                    onClick = {
                        navController.navigate("profile")
                    }
                )
                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }
}