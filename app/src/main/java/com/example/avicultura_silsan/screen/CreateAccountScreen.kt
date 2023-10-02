package com.example.avicultura_silsan.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.avicultura_silsan.components.createAccount.Header
import com.example.avicultura_silsan.universal.TextBox

@Composable
fun CreateAccountScreen(
    navController: NavController,
    lifecycleScope: LifecycleCoroutineScope?
){
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Header()
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun preview(){
    val navController = rememberNavController()
    CreateAccountScreen(navController = navController, lifecycleScope = null)
}