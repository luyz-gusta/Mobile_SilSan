package com.example.avicultura_silsan.components.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.example.avicultura_silsan.R
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Preview
@Composable
fun Card() {
    Column(
        Modifier
            .width(180.dp)
            .background(Color(255, 240, 230))
            .clip(RoundedCornerShape(10.dp)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)

    ) {
//        AsyncImage(
//            model = "https://www.google.com/search?q=ra%C3%A7%C3%A3o+de+cachorro&client=opera-gx&hs=FEZ&sca_esv=570220637&tbm=isch&sxsrf=AM9HkKkwE4wStUqQxvZGVbtUiXwQtQfbXQ:1696299231360&source=lnms&sa=X&ved=2ahUKEwjPwPiI59iBAxWnDrkGHRg_AckQ_AUoAnoECAMQBA&biw=1319&bih=619&dpr=1#imgrc=0Gll6MmRzyeyNM",
//            contentDescription = "Foto Produto",
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .width(175.dp)
//                .height(170.dp)
//        )
        Image(
            painter = painterResource(id = R.drawable.dogue),
            contentDescription = "Foto Produto",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(175.dp)
                .height(170.dp)
        )
        Text(
            text = "Ração Cachorro Special Dog adulto - 15kg",
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .width(180.dp)
                .padding(10.dp, 0.dp),
            textAlign = TextAlign.Start,
            fontSize = 12.sp
        )
        Text(
            text = "R$ 259,99",
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .width(180.dp)
                .padding(10.dp, 0.dp),
            textAlign = TextAlign.Start,
            fontSize = 12.sp,
            textDecoration = TextDecoration.LineThrough
        )
        Text(
            text = "R$ 229,99",
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .width(180.dp)
                .padding(10.dp, 0.dp),
            textAlign = TextAlign.Start,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(3.dp))
    }
}