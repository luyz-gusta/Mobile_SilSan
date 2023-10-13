package com.example.avicultura_silsan.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.avicultura_silsan.components.profile.FooterProfile
import com.example.avicultura_silsan.components.profile.FormProfile
import com.example.avicultura_silsan.components.profile.HeaderProfile
import com.example.avicultura_silsan.components.profile.MainProfile
import com.example.avicultura_silsan.view_model.UserViewModel

@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: UserViewModel
) {

    Column (
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        HeaderProfile{
            navController.navigate("feed")
        }
        MainProfile(viewModel, navController)
        Box(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
        )
        FooterProfile {
            navController.navigate("feed")
        }
    }
}