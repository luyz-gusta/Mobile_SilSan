package com.example.avicultura_silsan.components.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.avicultura_silsan.R
import com.example.avicultura_silsan.sqlite_repository.UserRepository

@Composable
fun HeaderFeed(
    onClick: () -> Unit
){
    val context = LocalContext.current

    var array = UserRepository(context).findUsers()
    var user = array[0]

    var nameParts = user.nome.split(" ")
    var firstName = nameParts[0]


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(color = colorResource(id = R.color.orange_default))
            .padding(15.dp, 0.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo da empresa",
            modifier = Modifier
                .height(90.dp)
                .width(160.dp)
        )
        Row (
            Modifier
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = firstName,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .width(80.dp),
                textAlign = TextAlign.End,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.width(6.dp))
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
}