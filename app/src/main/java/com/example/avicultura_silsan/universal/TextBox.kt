package com.example.avicultura_silsan.universal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.avicultura_silsan.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextBox(label : String, valor: String, aoMudar: (String) -> Unit ) {

    OutlinedTextField(
        value = valor,
        onValueChange = {
            aoMudar(it)
        },
        modifier = Modifier
            .height(60.dp)
            .width(300.dp),
        label = {
            Text(
                text = label
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.cinza ),
            unfocusedBorderColor = colorResource(id = R.color.cinza )
        )
    )
}


@Preview(showBackground = true)
@Composable
fun  TextBoxScreenPreview() {
    TextBox(label = "oi", valor = "12", aoMudar = {})
}