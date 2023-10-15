package com.example.avicultura_silsan.components.retrieve_account.insert_code

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import com.example.avicultura_silsan.components.retrieve_account.insert_email.ButtonInsertEmail
import com.example.avicultura_silsan.repository.RetriveAccountRepository
import com.example.avicultura_silsan.universal.ButtonDefault
import com.example.avicultura_silsan.view_model.RetrieveAccountViewModel
import kotlinx.coroutines.launch

@Composable
fun FormInsertCode(
    navController: NavController,
    lifecycleScope: LifecycleCoroutineScope,
    viewModel: RetrieveAccountViewModel,
    context: Context
) {
    var codigoState by remember {
        mutableStateOf("")
    }

    val email = viewModel.email

    Log.e("email", "FormInsertCode: $email", )

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Informe o código de verificação",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight(800),
                color = Color(0xFF000000),
            )
        )
        Box(
            modifier = Modifier
                .width(240.dp)
                .height(50.dp)
        ){
            Text(
                text = "Agora, insira o código que enviamos por e-mail para criar uma nova senha.",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                )
            )
        }

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterHorizontally),

                ) {
                TextFieldCode(
                    "Codigo",
                    codigoState
                ) {
                    codigoState = it
                }
            }
            Spacer(modifier = Modifier.height(64.dp))
            ButtonCode(
                text = "Continuar",
                color = 0xFFFF5C00,
                colorText = 0xFFFFFFFF,
                onClick = {
                    Log.e("Codigo", "FormInsertCode: ${codigoState.toInt()}", )
                    insertCode(navController, lifecycleScope, viewModel, context, codigoState.toInt())
                }
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

fun insertCode (
    navController: NavController,
    lifecycleScope: LifecycleCoroutineScope,
    viewModel: RetrieveAccountViewModel,
    context: Context,
    codigoState: Int
) {

    lifecycleScope.launch {
        val email = viewModel.email
        val code = viewModel.code

        if(insertCodeValidation(codigoState)){
            Toast.makeText(context, "CODIGO DIGITADO INVÁLIDO", Toast.LENGTH_SHORT).show()
        }else if(code == codigoState){
            viewModel.email = ""

            navController.navigate("reset_password")
            Log.e("Inset-Code-Sucess", "Sucesso", )
            Toast.makeText(context, "CÓDIGO VÁLIDO", Toast.LENGTH_SHORT).show()
        }else{
            Log.e("Inset-Code", "ERROU", )
            Toast.makeText(context, "CÓDIGO INVÁLIDO", Toast.LENGTH_LONG).show()
        }
    }
}
fun insertCodeValidation (codigo: Int): Boolean {
    return (codigo.countOneBits() == 4)
}
