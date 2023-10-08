package com.example.avicultura_silsan.universal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.avicultura_silsan.R

@Composable
fun ButtonDefault(
    text: String,
    color: Long,
    onClick: () -> Unit
) {
    TextButton(
        onClick = {
            onClick()
        },
        modifier = Modifier
            .width(280.dp)
            .height(41.dp)
            .background(color = Color(color), shape = RoundedCornerShape(size = 8.dp))
    ) {
        Text(
            text = text,
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.intermedium)),
            fontWeight = FontWeight(600),
            color = Color(0xFFFFFFFF),
        )
    }
}