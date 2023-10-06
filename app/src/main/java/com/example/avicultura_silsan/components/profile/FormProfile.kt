package com.example.avicultura_silsan.components.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun FormProfile() {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp, 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextBoxProfile()
    }
}