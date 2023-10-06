package com.example.avicultura_silsan.components.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAPhoto
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.avicultura_silsan.R
import com.example.avicultura_silsan.sqlite_repository.UserRepository

@Preview
@Composable
fun HeaderProfile() {

    var icons = Icons.Default.ArrowBack

    var camera = Icons.Default.AddAPhoto

    val context = LocalContext.current

    val dadaUser = UserRepository(context).findUsers()

    val user = dadaUser[0]


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(top = 32.dp),
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(43.dp, Alignment.Start),
            verticalAlignment = Alignment.Top,
        ) {
            IconButton(
                onClick = {
                   // navController.navigate("navigation_home_bar")
                },
                modifier = Modifier
                    .height(64.dp)
                    .width(64.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFCECECE),
                        shape = RoundedCornerShape(size = 8.dp)
                    )
            ) {
                Icon(
                    imageVector = icons,
                    contentDescription = ""
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(18.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Box(
                    modifier = Modifier.size(100.dp),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    Card(
                        modifier = Modifier
                            .size(100.dp),
                        shape = CircleShape,
                        border = BorderStroke(
                            width = 2.dp,
                            Brush.horizontalGradient(
                                listOf(
                                    colorResource(id = R.color.purple_200),
                                    Color.White
                                )
                            )
                        )
                    ) {
                        Image(
                            painter = painterResource(
                                id = R.drawable.susanna_profile
                            ),
                            contentDescription = "",
                            modifier = Modifier.size(64.dp)
                        )
                    }
                    Icon(
                        imageVector = camera,
                        contentDescription = "",
                        modifier = Modifier
                            .offset(x = 5.dp, y = 5.dp)
                            .size(28.dp),
                    )
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {

                    Text(
                        text = user.nome,
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.intermedium)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000),
                    )

                }

            }
            IconButton(
                onClick = {
                    //navController.navigate("EditUser")
                },
                modifier = Modifier
                    .height(64.dp)
                    .width(64.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFCECECE),
                        shape = RoundedCornerShape(size = 8.dp)
                    )
            ) {
                Image(
                    modifier = Modifier
                        .height(22.dp)
                        .width(25.dp),
                    painter = painterResource(
                        id = R.drawable.editar
                    ),
                    contentDescription = ""
                )
            }
        }
    }
}