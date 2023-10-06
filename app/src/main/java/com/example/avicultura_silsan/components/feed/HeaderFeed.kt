package com.example.avicultura_silsan.components.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.avicultura_silsan.R

//@Preview
@Composable
fun HeaderFeed(
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 1.dp, color = Color(0xFFE9E9E9))
            .height(80.dp)
            .padding(25.dp, 0.dp)
            .background(Color.White) ,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .height(80.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_dog),
                contentDescription = "Logo somente com o cachorro",
                modifier = Modifier.size(60.dp)
            )
            Text(
                text = "Avicultura Silsan",
                fontFamily = FontFamily(Font(R.font.glory_variable)),
                fontWeight = FontWeight(600),
                fontSize = 24.sp,
                color = colorResource(id = R.color.black)
            )
        }
        Image(
            painterResource(id = R.drawable.icon_count),
            contentDescription = "Icon User",
            modifier = Modifier
                .size(50.dp)
                .clickable {
                    onClick()
                }
        )
    }
}