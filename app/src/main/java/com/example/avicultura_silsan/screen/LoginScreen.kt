package com.example.avicultura_silsan.screen

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.avicultura_silsan.R
import com.example.avicultura_silsan.components.login.DefaultButton
import com.example.avicultura_silsan.components.login.Form
import com.example.avicultura_silsan.components.login.Header
import com.example.avicultura_silsan.components.login.TextNotCont
import com.example.avicultura_silsan.functions.deleteUserSQLite
import com.example.avicultura_silsan.functions.saveLogin
import com.example.avicultura_silsan.repository.LoginRepository
import com.example.avicultura_silsan.sqlite_repository.UserRepository
import com.example.avicultura_silsan.view_model.UserViewModel
import kotlinx.coroutines.launch
import org.json.JSONObject

@Composable
fun LoginScreen(
    navController: NavController,
    lifecycleScope: LifecycleCoroutineScope?,
    viewModel: UserViewModel
) {
    val context = LocalContext.current

    var emailState by remember {
        mutableStateOf("")
    }

    var senhaState by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White), // Torna o fundo da Column transparente
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Header()
            Spacer(
                modifier = Modifier
                    .height(15.dp)
            )
            Form(
                emailState,
                senhaState,
                onEmailChange = { emailState = it },
                onSenhaChange = { senhaState = it },
                navController
            )
            Spacer(
                modifier = Modifier
                    .height(15.dp)
            )
            DefaultButton(
                text = "Entrar",
                onClick = {
                    login(
                        emailState,
                        senhaState,
                        lifecycleScope!!,
                        context,
                        navController,
                        viewModel = viewModel
                    )
                }
            )
            TextNotCont(navController = navController)
        }
    }
}

fun login(
    email: String,
    senha: String,
    lifecycleScope: LifecycleCoroutineScope,
    context: Context,
    navController: NavController,
    viewModel: UserViewModel
){

    if(email == "" || senha == ""){
        Toast.makeText(context, "Email ou senha não foi inserido", Toast.LENGTH_LONG).show()
    }else {
        val loginRepository = LoginRepository()

        lifecycleScope.launch {
            val response = loginRepository.loginUsuario(email, senha)

            if(response.isSuccessful){

                val jsonString = response.body().toString()
                val jsonObject = JSONObject(jsonString)

                if(jsonObject.getJSONObject("cliente") == null ){
                    Toast.makeText(context, "Somente cliente pode acessar o sistema", Toast.LENGTH_LONG).show()
                }else{
                    val cliente = jsonObject.getJSONObject("cliente")
                    val id_client = cliente.getInt("id")
                    val nome = cliente.getString("nome")
                    val telefone = cliente.getString("telefone")
                    val dataNascimento = cliente.getString("data_nascimento")

                    val user = jsonObject.getJSONObject("usuario")
                    val email = user.getString("email")
                    val senha = user.getString("senha")
                    val id_user = user.getInt("id")
                    val id_status_usuario = user.getInt("id_status_usuario")

                    Log.e("LOGIN - SUCESS - 201", "login: ${response.body()}")
                    Log.e("User", "login: ${user}")
                    Log.e("Client", "login: ${cliente}")
                    Toast.makeText(context, "Bem vindo $nome ao nosso sistema", Toast.LENGTH_SHORT).show()

                    viewModel.id_cliente = id_client
                    viewModel.nome = nome
                    viewModel.telefone = telefone
                    viewModel.data_nascimento = dataNascimento

                    Log.e("DN", "login: $dataNascimento", )

                    viewModel.id_usuario = id_user
                    viewModel.email = email
                    viewModel.senha = senha

                    viewModel.id_status_usuario = id_status_usuario

                    if(UserRepository(context).findUsers().isEmpty()){

                        saveLogin(
                            context,
                            id_user = id_user,
                            id_client = id_client,
                            email = email,
                            senha = senha,
                            nome = nome,
                            telefone,
                            dataNascimento
                        )

                    }else{
                        deleteUserSQLite(context)

                        saveLogin(
                            context,
                            id_user = id_user,
                            id_client = id_client,
                            email = email,
                            senha = senha,
                            nome = nome,
                            telefone,
                            dataNascimento
                        )

                    }

                    navController.navigate("feed")
                }
            }else{

                when(response.code()){

                    404 -> {
                        Log.e("LOGIN - ERROR - 404", "login: ${response.errorBody()?.string()}")

                        Toast.makeText(
                            context, "O EMAIL OU SENHA INFORMADO NÃO É VALIDADO", Toast.LENGTH_LONG
                        ).show()
                    }

                    500 -> {
                        Log.e("LOGIN - ERROR - 500", "login: ${response.errorBody()?.string()}")

                        Toast.makeText(
                            context,
                            "SERVIDOR INDISPONIVEL NO MOMENTO, TENTE MAIS TARDE",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }
    }
}