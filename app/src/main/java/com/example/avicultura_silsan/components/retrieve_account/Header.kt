package com.example.avicultura_silsan.components.retrieve_account

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.avicultura_silsan.R

@Preview
@Composable
fun HeaderRetrieveAccount() {
    Row(
        modifier = Modifier
            .height(75.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_dog),
            contentDescription = "Logo somente com o cachorro",
            modifier = Modifier.size(55.dp)
        )
        Text(
            text = "Avicultura Silsan",
            fontFamily = FontFamily(Font(R.font.glory_medium)),
            fontWeight = FontWeight(500),
            fontSize = 20.sp,
            color = colorResource(id = R.color.black)
        )
    }

}