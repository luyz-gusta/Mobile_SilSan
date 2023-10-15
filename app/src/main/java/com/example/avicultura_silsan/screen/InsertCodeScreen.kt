package com.example.avicultura_silsan.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import com.example.avicultura_silsan.components.retrieve_account.HeaderRetrieveAccount
import com.example.avicultura_silsan.components.retrieve_account.insert_code.FormInsertCode
import com.example.avicultura_silsan.view_model.RetrieveAccountViewModel

@Composable
fun InsertCodeScreen(
    navController: NavController,
    lifecycleScope: LifecycleCoroutineScope,
    viewModel: RetrieveAccountViewModel
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .padding(30.dp, 15.dp)
    ) {
        HeaderRetrieveAccount()
        Spacer(modifier = Modifier.height(65.dp))
        FormInsertCode(
            navController,
            lifecycleScope,
            viewModel,
            context
        )
    }
}