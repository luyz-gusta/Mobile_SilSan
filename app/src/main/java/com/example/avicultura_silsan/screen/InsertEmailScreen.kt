package com.example.avicultura_silsan.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import com.example.avicultura_silsan.components.retrieve_account.HeaderRetrieveAccount
import com.example.avicultura_silsan.components.retrieve_account.insert_email.FooterInsertEmail
import com.example.avicultura_silsan.components.retrieve_account.insert_email.FormInsertEmail
import com.example.avicultura_silsan.view_model.RetrieveAccountViewModel

@Composable
fun InsertEmailScreen(
    navController: NavController,
    lifecycleScope: LifecycleCoroutineScope,
    viewModel: RetrieveAccountViewModel
) {
    var emailState by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp, 15.dp)
            .background(Color.White)
    ) {
        HeaderRetrieveAccount()
        Spacer(modifier = Modifier.height(25.dp))
        FormInsertEmail(emailState, onEmailChange = {
            emailState = it
        })
        Spacer(modifier = Modifier.height(70.dp))
        FooterInsertEmail(navController, lifecycleScope, viewModel,emailState)
    }
}