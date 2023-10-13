package com.example.avicultura_silsan.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.avicultura_silsan.components.retrieve_account.HeaderRetrieveAccount
import com.example.avicultura_silsan.components.retrieve_account.insert_email.FooterInsertEmail
import com.example.avicultura_silsan.components.retrieve_account.insert_email.FormInsertEmail

@Preview
@Composable
fun InsertEmailScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp, 15.dp)
            .background(Color.White)
    ) {
        HeaderRetrieveAccount()
        Spacer(modifier = Modifier.height(25.dp))
        FormInsertEmail()
        Spacer(modifier = Modifier.height(70.dp))
        FooterInsertEmail()
    }
}