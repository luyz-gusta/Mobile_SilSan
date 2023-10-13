package com.example.avicultura_silsan.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.avicultura_silsan.components.retrieve_account.HeaderRetrieveAccount
import com.example.avicultura_silsan.components.retrieve_account.reset_password.FormResetPassword

@Preview
@Composable
fun ResetPasswordScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp, 15.dp)
    ) {
        HeaderRetrieveAccount()
        Spacer(modifier = Modifier.height(25.dp))
        FormResetPassword()
    }
}