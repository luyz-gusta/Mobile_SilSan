package com.example.avicultura_silsan.components.retrieve_account.insert_email

import android.content.Context
import android.util.Log
import android.widget.Toast
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
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import com.example.avicultura_silsan.repository.RetriveAccountRepository
import com.example.avicultura_silsan.view_model.RetrieveAccountViewModel
import kotlinx.coroutines.launch

@Composable
fun FooterInsertEmail(
    navController: NavController,
    lifecycleScope: LifecycleCoroutineScope,
    viewModel: RetrieveAccountViewModel,
    emailState: String
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
                if (viewModel.email == "")
                    Toast.makeText(
                        context,
                        "VOCÊ NÃO ENVIO NENHUM CÓDIGO PARA SEU EMAIL, A PARTIR DESTE DISPOSITIVO",
                        Toast.LENGTH_SHORT
                    ).show()
                else
                    navController.navigate("insert_code")
            }
        )
        ButtonInsertEmail(
            text = "Solicitar código",
            color = 0xFFFF5C00,
            onClick = {
                enviarEmail(emailState, lifecycleScope, viewModel, navController, context)
            }
        )
    }
}


fun enviarEmail(
    email: String,
    lifecycleScope: LifecycleCoroutineScope,
    viewModel: RetrieveAccountViewModel,
    navController: NavController,
    context: Context
) {
    val resetRepository = RetriveAccountRepository()

    if (validationEmail(email)) {
        lifecycleScope.launch {
            val response = resetRepository.insertEmail(email)
            val code = response.code()

            if (response.isSuccessful) {
                viewModel.email = response.body()?.get("email")?.toString()
                viewModel.code = response.body()?.get("token")?.asInt
                viewModel.id = response.body()?.get("id")?.asInt

                Log.e("FORGOT PASSWORD - SUCESS - 201", "forgot_password: ${response.body()}")
                Toast.makeText(context, "CÓDIGO ENVIADO COM SUCESSOS", Toast.LENGTH_SHORT).show()

                navController.navigate("insert_code")
            } else {
                if (code == 400) {
                    Log.e(
                        "FORGOT PASSWORD - ERROR - 400",
                        "login: ${response.errorBody()?.string()}"
                    )
                    Toast.makeText(
                        context,
                        "O NÃO FOI DIGITADO OU NÃO É VÁLIDO",
                        Toast.LENGTH_LONG
                    ).show()
                }
                Log.e("FORGOT PASSWORD", "forgot_password: ${response.errorBody()?.string()}")
            }
        }
    } else {
        Log.e("FORGOT PASSWORD - ERROR", "forgot_password")
        Toast.makeText(context, "EMAIL OU SENHA NÃO INSERIDO CORRETAMENTE", Toast.LENGTH_LONG)
            .show()
    }
}

fun validationEmail(email: String): Boolean {
    return !(email.length > 255 || email == "")
}