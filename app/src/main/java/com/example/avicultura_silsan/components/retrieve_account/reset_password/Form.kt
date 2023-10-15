package com.example.avicultura_silsan.components.retrieve_account.reset_password

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import com.example.avicultura_silsan.components.login.TextFieldPassword
import com.example.avicultura_silsan.components.retrieve_account.insert_code.ButtonCode
import com.example.avicultura_silsan.repository.RetriveAccountRepository
import com.example.avicultura_silsan.view_model.RetrieveAccountViewModel
import kotlinx.coroutines.launch

@Composable
fun FormResetPassword(
    navController: NavController,
    lifecycleScope: LifecycleCoroutineScope,
    viewModel: RetrieveAccountViewModel,
    contexto: Context
) {

    var senhaState by remember {
        mutableStateOf("")
    }

    var confirmSenhaState by remember {
        mutableStateOf("")
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .padding(start = 12.dp),
        ) {
            Text(
                text = "Recuperação de senha",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(800),
                    color = Color(0xFF000000),
                )
            )

            Text(
                text = "Crie sua nova senha abaixo",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                )
            )
        }
        Column (
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TextFieldPassword(
                label = "Nova senha",
                valor = senhaState,
                aoMudar = {
                    senhaState = it
                }
            )
            TextFieldPassword(
                label = "Confirmar senha" ,
                valor = confirmSenhaState,
                aoMudar ={
                    confirmSenhaState = it
                }
            )
            ButtonPassword(
                text = "Redefinir senha",
                color = 0xFFFF5C00,
                colorText = 0xFFFFFFFF
            ) {
                changePassword(
                    navController = navController,
                    lifecycleScope = lifecycleScope,
                    viewModel = viewModel,
                    senha = senhaState,
                    confirmarSenha = confirmSenhaState,
                    contexto
                )
            }
        }
    }
}

fun changePassword (
    navController: NavController,
    lifecycleScope: LifecycleCoroutineScope,
    viewModel: RetrieveAccountViewModel,
    senha: String,
    confirmarSenha: String,
    contexto: Context
) {
    if(senha.length < 8){
        Toast.makeText(contexto, "SENHA TEM QUE TER NO MINIMO 8 DIGITOS", Toast.LENGTH_SHORT).show()
    }else if(senha == confirmarSenha){
        val id = viewModel.id
        val changePasswordRepository = RetriveAccountRepository()

        lifecycleScope.launch {
            val response = changePasswordRepository.mudarSenha(id, senha)

            Log.e("Tag", "changePassword: $response", )

            if(response.isSuccessful){
                navController.navigate("login")
                Toast.makeText(contexto, "SENHA ALTERADO COM SUCESSO", Toast.LENGTH_SHORT).show()
            }else{
                val erroBody = response.errorBody()?.string()

                Toast.makeText(contexto, "ERRO, NÃO FOI POSSIVEL ATUALIZAR SENHA", Toast.LENGTH_SHORT).show()
                Log.e("reset de senha", "reset de senha: $erroBody")
            }
        }
    }else{
        Toast.makeText(contexto, "As senha estão diferentes", Toast.LENGTH_SHORT).show()
    }
}
