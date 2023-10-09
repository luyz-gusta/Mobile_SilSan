package com.example.avicultura_silsan.screen

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.avicultura_silsan.components.createAccount.Form
import com.example.avicultura_silsan.components.createAccount.Header
import com.example.avicultura_silsan.components.createAccount.TextAccount
import com.example.avicultura_silsan.components.login.DefaultButton
import com.example.avicultura_silsan.functions.deleteUserSQLite
import com.example.avicultura_silsan.functions.saveLogin
import com.example.avicultura_silsan.repository.CadastroRepository
import com.example.avicultura_silsan.sqlite_repository.UserRepository
import com.example.avicultura_silsan.universal.TextBox
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

@Composable
fun CreateAccountScreen(
    navController: NavController,
    lifecycleScope: LifecycleCoroutineScope?
) {
    val context = LocalContext.current

    var nomeState by remember {
        mutableStateOf("")
    }
    var telefoneState by remember {
        mutableStateOf("")
    }
    var dataNascimentoState by remember {
        mutableStateOf("")
    }
    var emailState by remember {
        mutableStateOf("")
    }
    var senhaState by remember {
        mutableStateOf("")
    }
    var confirmaSenhaState by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Header()
        Form(
            nomeState,
            telefoneState,
            dataNascimentoState,
            emailState,
            senhaState,
            confirmaSenhaState,
            onNomeChange = { nomeState = it },
            onTelefoneChange = { telefoneState = it },
            onDataNascimentoChange = { dataNascimentoState = it },
            onEmailChange = { emailState = it },
            onSenhaChange = { senhaState = it },
            onConfirmaSenhaChange = { confirmaSenhaState = it }
        )
        Spacer(modifier = Modifier.height(10.dp))
        DefaultButton(
            text = "Criar",
            onClick = {
                Log.e(
                    "Dados",
                    "Nome: $nomeState, Telefone: $telefoneState, Data: $dataNascimentoState, Email: $emailState, Senha:$senhaState"
                )

                cadastro(
                    nomeState,
                    telefoneState,
                    dataNascimentoState,
                    emailState,
                    senhaState,
                    confirmaSenhaState,
                    lifecycleScope!!,
                    navController,
                    context
                )
            }

        )

        Spacer(modifier = Modifier.height(10.dp))
        TextAccount {
            navController.navigate("login")
        }
    }

}

fun cadastro(
    nome: String,
    telefone: String,
    dataNascimento: String,
    email: String,
    senha: String,
    confirmaSenha: String,
    lifecycleScope: LifecycleCoroutineScope,
    navController: NavController,
    context: Context
) {

    if (nome == "" || telefone == "" || email == "" || dataNascimento == "" || senha == "" || confirmaSenha == "") {
        Toast.makeText(context, "Ha campos em aberto", Toast.LENGTH_LONG).show()
        Log.e("CADASTRO - ERROR", "CADASTRO_V1: REQUIRE FIELDS")

    }else if (senha == confirmaSenha){
        val cadastroRepository = CadastroRepository()


        lifecycleScope.launch {
            //val response = cadastroRepository.cadastroUsuario(nome,telefone,email,dataNascimento,senha)
            val response = cadastroRepository.cadastroUsuario(
                nome = nome,
                telefone = telefone,
                email = email,
                dataNascimento = dataNascimento.toAmericanDateFormat(),
                senha = senha
            )

            if (response.isSuccessful) {

                val jsonString = response.body().toString()
                val jsonObject = JSONObject(jsonString)

                val cliente = jsonObject.getJSONObject("cliente")
                val emailClient = cliente.getString("email")
                val nome = cliente.getString("nome")

                Log.e("Cadastro - SUCESS - 201", "Cadastro: ${response.body()}")
                Toast.makeText(context, "Bem vindo $nome ao nosso sistema", Toast.LENGTH_SHORT)
                    .show()

                navController.navigate("login")
            } else {
                Log.e("Cadastro - ERROR - 999", "Cadastro: ${response.errorBody()?.string()}")
                Toast.makeText(context, "fudeu no 999", Toast.LENGTH_SHORT).show()
                Log.e("COODE01", "cadastro: ${response.code()}")

                when (response.code()) {
                    400 -> {
                        Log.e(
                            "Cadastro - ERROR - 400",
                            "Cadastro: ${response.errorBody()?.string()}"
                        )

                        Toast.makeText(
                            context,
                            "NÃO FOI PREENCHIDO TODOS OS CAMPOS OBRIGATÓRIOS",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    404 -> {
                        Log.e(
                            "Cadastro - ERROR - 404",
                            "Cadastro: ${response.errorBody()?.string()}"
                        )
                        Toast.makeText(context, "Sla nao sei esse erro nao", Toast.LENGTH_LONG)
                            .show()
                    }

                    500 -> {
                        Log.e("CADASTRO - ERROR - 500", "login: ${response.errorBody()?.string()}")

                        Toast.makeText(
                            context,
                            "SERVIDOR INDISPONIVEL NO MOMENTO, TENTE MAIS TARDE",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }
    }else {
        Toast.makeText(context, "SENHA INVÁLIDA", Toast.LENGTH_LONG).show()
        Log.e("CADASTRO - ERROR", "CADASTRO: SENHA INVÁLIDA")
    }
}

fun String.toAmericanDateFormat(
    pattern: String = "yyyy-MM-dd"
): String {
    val date = Date(this)
    val formatter = SimpleDateFormat(
        pattern, Locale("pt-br")
    ).apply {
        timeZone = TimeZone.getTimeZone("GMT")
    }
    return formatter.format(date)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun preview() {
    val navController = rememberNavController()

    CreateAccountScreen(navController = navController, lifecycleScope = null)
}