package com.example.avicultura_silsan.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.avicultura_silsan.components.feed.HeaderFeed
import com.example.avicultura_silsan.components.feed.ListCard
import com.example.avicultura_silsan.view_model.AnuncioViewModel

@Composable
fun FeedScreen(
    navController: NavController,
    viewModel: AnuncioViewModel
) {
    val context = LocalContext.current

    Column(
        Modifier
            .fillMaxSize()
    ) {
        HeaderFeed{
            navController.navigate("profile")
        }
        ListCard(navController, viewModel)

    }
}