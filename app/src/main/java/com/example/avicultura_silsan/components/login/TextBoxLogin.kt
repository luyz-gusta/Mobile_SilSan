package com.example.avicultura_silsan.components.login

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
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextBoxScreen(label : String, valor: String, aoMudar: (String) -> Unit ) {

    OutlinedTextField(
        value = valor,
        onValueChange = {
            aoMudar(it)
        },
        modifier = Modifier
            .height(60.dp)
            .width(300.dp)
            .background(Color(255, 255, 255), shape = RoundedCornerShape(20.dp)),
        label = {
            Text(
                text = label,
                color = Color.Black
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.White,
            unfocusedBorderColor = Color.White,
            cursorColor = Color.Black
        )
    )
}
    //modifier = Modifier
    //            .border(width = 0.8.dp,
    //        color = Color(0xFFCECECE),
    //        )
//        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
//        leadingIcon = {
//            Icon(
//                painter = painterResource(
//                    id = R.drawable.baseline_lock_24
//                ),
//                contentDescription = "",
//                tint = colorResource(id = R.color.pink_login)
//            )
//        }





//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun  TextBoxScreenPreview() {
//    TextBoxScreen(label = "oi", valor = "12", aoMudar = )
//}