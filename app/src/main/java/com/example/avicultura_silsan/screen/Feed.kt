package com.example.avicultura_silsan.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.avicultura_silsan.components.feed.HeaderFeed

@Preview
@Composable
fun FeedScreen(
) {
    val context = LocalContext.current

    Column(
        Modifier
            .fillMaxSize()
    ) {
        HeaderFeed {}

    }
}