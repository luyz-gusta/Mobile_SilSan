package com.example.avicultura_silsan.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.avicultura_silsan.components.retrieve_account.HeaderRetrieveAccount
import com.example.avicultura_silsan.components.retrieve_account.insert_code.FormInsertCode

@Preview
@Composable
fun InsertCodeScreen() {
    Column(
        modifier = Modifier
            .padding(30.dp, 15.dp)
    ) {
        HeaderRetrieveAccount()
        Spacer(modifier = Modifier.height(65.dp))
        FormInsertCode()
    }
}