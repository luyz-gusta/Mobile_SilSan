package com.example.avicultura_silsan.components.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.avicultura_silsan.R
import com.example.avicultura_silsan.universal.ButtonDefault
import com.example.avicultura_silsan.view_model.UserViewModel

@Composable
fun MainProfile(
    viewModel: UserViewModel,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .height(500.dp),
        verticalArrangement = Arrangement.spacedBy(50.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            text = "Informações do Usuário",
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.intermedium)),
                fontWeight = FontWeight(600),
                color = Color(0xFFAA6231),
            ),
            textAlign = TextAlign.Start
        )
        FormProfile(viewModel)

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(0.dp, 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            ButtonDefault(text = "Sair", color = 0xFFFF5C00) {
                navController.navigate("login")
            }
        }

    }
}