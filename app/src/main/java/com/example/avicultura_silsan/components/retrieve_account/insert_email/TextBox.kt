package com.example.avicultura_silsan.components.retrieve_account.insert_email

import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.avicultura_silsan.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextBoxInsertEmail(label : String, valor: String, aoMudar: (String) -> Unit ) {
    OutlinedTextField(
        value = valor,
        onValueChange = {
            aoMudar(it)
        },
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth(),
        label = {
            Text(
                text = label,
                color = Color.Black
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.cinza ),
            unfocusedBorderColor = colorResource(id = R.color.cinza )
        ),
        textStyle = TextStyle(
            color = Color.Black
        )
    )
}