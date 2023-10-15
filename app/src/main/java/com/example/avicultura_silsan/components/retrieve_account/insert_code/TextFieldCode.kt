package com.example.avicultura_silsan.components.retrieve_account.insert_code

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.avicultura_silsan.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldCode(label : String, valor: String, aoMudar: (String) -> Unit ) {

    val maxLength = 4

    OutlinedTextField(
        value = valor,
        onValueChange = {
            if(it.length <= maxLength){
                aoMudar(it)
            }
        },
        label={
            Text(
                text = label,
                fontSize = 12.sp,
                fontWeight = FontWeight(600),
                color = Color(159,152,152,)
            )
        },
        modifier = Modifier
            .height(60.dp)
            .width(150.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.cinza ),
            unfocusedBorderColor = colorResource(id = R.color.cinza )
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}