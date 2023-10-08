package com.example.avicultura_silsan.components.profile

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.avicultura_silsan.view_model.UserViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

@Composable
fun FormProfile(
    viewModel: UserViewModel
) {
    val data = viewModel.data_nascimento.toBrazilianDateFormat()

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp, 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        TextBoxProfile(nomeValor = "Nome", valor = viewModel.nome)
        TextBoxProfile(nomeValor = "Email", valor = viewModel.email)
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Log.e("Data", "FormProfile: ${viewModel.data_nascimento.toBrazilianDateFormat()}")
            TextBoxProfileReduced(nomeValor = "Data de nascimento", valor = data)
            TextBoxProfileReduced(nomeValor = "Telefone", valor = viewModel.telefone)
        }
    }
}

fun String.toBrazilianDateFormat(
    pattern: String = "dd/MM/yyyy" //"yyyy-MM-dd"
): String {
    val formatter = SimpleDateFormat(
        "yyyy-MM-dd", Locale("pt-br")
    ).apply {
        timeZone = TimeZone.getTimeZone("GMT")
    }

    val date = formatter.parse(this)

    val brazilianFormatter = SimpleDateFormat(
        pattern, Locale("pt-br")
    )

    return brazilianFormatter.format(date!!)
}

//fun String.toBrazilianDateFormat(
//    pattern: String = "dd/MM/yyyy"
//): String {
//    val formatter = SimpleDateFormat(
//        "yyyy-MM-dd", Locale("pt-br")
//    ).apply {
//        timeZone = TimeZone.getTimeZone("GMT")
//    }
//
//    try {
//        val date = formatter.parse(this)
//        if (date != null) {
//            val brazilianFormatter = SimpleDateFormat(
//                pattern, Locale("pt-br")
//            )
//            return brazilianFormatter.format(date)
//        }
//    } catch (e: ParseException) {
//        // Lida com o erro de análise, se ocorrer.
//        e.printStackTrace()
//    }
//
//    // Retorna a string original se a conversão falhar.
//    return this
//}
