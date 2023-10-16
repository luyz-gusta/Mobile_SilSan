package com.example.avicultura_silsan.components.createAccount

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.avicultura_silsan.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneBox(label: String, valor: String, aoMudar: (String) -> Unit) {

    val numericValue = valor.filter { it.isDigit() }

    OutlinedTextField(
        value = numericValue,
        onValueChange = {
            if (it.length <= 11) {
                aoMudar(it)
            }
        },
        modifier = Modifier
            .height(60.dp)
            .width(300.dp),
        label = {
            Text(
                text = label,
                color = Color.Black
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.cinza),
            unfocusedBorderColor = colorResource(id = R.color.cinza)
        ),
        textStyle = TextStyle(
            color = Color.Black
        )
    )
}
