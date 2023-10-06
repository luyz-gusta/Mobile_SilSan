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

@Composable
fun CreateAccountScreen(
    navController: NavController,
    lifecycleScope: LifecycleCoroutineScope?
){
    val context = LocalContext.current

    var nomeState by remember{
        mutableStateOf("")
    }
    var telefoneState by remember{
        mutableStateOf("")
    }
    var dataNascimentoState by remember{
        mutableStateOf("")
    }
    var emailState by remember{
        mutableStateOf("")
    }
    var senhaState by remember{
        mutableStateOf("")
    }
    var confirmasenhaState by remember{
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
            navController = navController
        )
        Spacer(modifier = Modifier.height(10.dp))
        DefaultButton(
            text = "Criar",
            onClick = { cadastro(
                nomeState,
                telefoneState,
                dataNascimentoState,
                emailState,
                senhaState,
                confirmasenhaState,
                lifecycleScope!!,
                navController,
                context
            ) }

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
    confirmasenha: String,
    lifecycleScope: LifecycleCoroutineScope,
    navController: NavController,
    context: Context
){

    if(nome == "" || telefone == "" || email == "" || dataNascimento == "" || senha == "" || confirmasenha == ""){
        Toast.makeText(context, "Ha campos em aberto", Toast.LENGTH_LONG).show()
    }else {
        val cadastroRepository = CadastroRepository()

        lifecycleScope.launch {
            val response = cadastroRepository.cadastroUsuario(nome,telefone,email,dataNascimento,senha,confirmasenha)

            if(response.isSuccessful){

                val jsonString = response.body().toString()
                val jsonObject = JSONObject(jsonString)

                val cliente = jsonObject.getJSONObject("id")
                val nome = jsonObject.getJSONObject("nome")
                val telefone = cliente.getString("telefone")
                val dataNacimento = cliente.getString("data_nascimento")
                val idUsuario = cliente.getString("id_Usuario")
                val emailClient = cliente.getString("email")

                val user = jsonObject.getJSONObject("usuario")
                val emailUser = user.getString("email")
                val senha = user.getString("senha")
                val id_user = user.getString("id")

                Log.e("Cadastro - SUCESS - 201", "Cadastro: ${response.body()}")
                Toast.makeText(context, "Bem vindo $nome ao nosso sistema", Toast.LENGTH_SHORT).show()


                navController.navigate("Feed")
            }else{

                when(response.code()){

                    404 -> {
                        Log.e("Cadastro - ERROR - 404", "Cadastro: ${response.errorBody()?.string()}")

                        Toast.makeText(context, "Há campos em aberto", Toast.LENGTH_LONG).show()
                    }

                    500 -> {
                        Log.e("LOGIN - ERROR - 500", "login: ${response.errorBody()?.string()}")

                        Toast.makeText(context, "SERVIDOR INDISPONIVEL NO MOMENTO, TENTE MAIS TARDE", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun preview(){
    val navController = rememberNavController()
    CreateAccountScreen(navController = navController, lifecycleScope = null)
}