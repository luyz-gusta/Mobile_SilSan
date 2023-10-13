package com.example.avicultura_silsan.components.retrieve_account.insert_code

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonCode (
    text: String,
    color: Long,
    colorText: Long,
    onClick: () -> Unit
){
    Row(
        modifier = Modifier
            .shadow(elevation = 4.dp, spotColor = Color(0x40000000), ambientColor = Color(0x40000000))
            .fillMaxWidth()
            .height(48.dp)
            .background(Color(color), shape = RoundedCornerShape( size = 4.dp))
            .padding()
            .clickable { onClick() },
        horizontalArrangement = Arrangement.spacedBy(2.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight(700),
                color = Color(colorText),
            )
        )
    }
}