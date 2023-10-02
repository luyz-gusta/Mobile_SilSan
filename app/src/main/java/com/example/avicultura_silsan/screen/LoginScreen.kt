package com.example.avicultura_silsan.screen

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

@Composable
fun LoginScreen(
    navController: NavController,
    lifecycleScope: LifecycleCoroutineScope?
) {
    var emailState by remember {
        mutableStateOf("")
    }

    var senhaState by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.dogue),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // Para ajustar a escala da imagem como fundo
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent), // Torna o fundo da Column transparente
            horizontalAlignment = Alignment.CenterHorizontally
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
                null
            )
            Spacer(
                modifier = Modifier
                    .height(15.dp)
            )
            DefaultButton(
                text = "Entrar",
                onClick = {
                    // Lógica de clique do botão
                }
            )
            TextNotCont(navController = null)
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun previewLogin() {
    val navController = rememberNavController()

    LoginScreen(navController = navController, lifecycleScope = null)
}