package com.example.avicultura_silsan.components.retrieve_account.insert_email

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun FooterInsertEmail(
//    navController: NavController,
//    lifecycleScope: LifecycleCoroutineScope,
//    viewModel: ResetPasswordView,
//    emailState: String
) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Já tenho o código de redefinição",
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFF9F9898),
                textDecoration = TextDecoration.Underline,
            ),
            modifier = Modifier.clickable {
//                if (viewModel.email == "")
//                    Toast.makeText(
//                        context,
//                        "VOCÊ NÃO ENVIO NENHUM CÓDIGO PARA SEU EMAIL, A PARTIR DESTE DISPOSITIVO",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                else
//                    navController.navigate("insert_code")
            }
        )
        ButtonInsertEmail(
            text = "Solicitar código",
            color = 0xFFFF5C00,
            onClick = {

            }
        )
    }
}