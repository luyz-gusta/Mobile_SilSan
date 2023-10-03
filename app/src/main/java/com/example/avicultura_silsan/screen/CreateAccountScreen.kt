package com.example.avicultura_silsan.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
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
import com.example.avicultura_silsan.universal.TextBox

@Composable
fun CreateAccountScreen(
    navController: NavController,
    lifecycleScope: LifecycleCoroutineScope?
){
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Header()
        Form(navController = navController)
        Spacer(modifier = Modifier.height(10.dp))
        DefaultButton(
            text = "Criar"
        ) {}
        Spacer(modifier = Modifier.height(10.dp))
        TextAccount {
            navController.navigate("login")
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun preview(){
    val navController = rememberNavController()
    CreateAccountScreen(navController = navController, lifecycleScope = null)
}