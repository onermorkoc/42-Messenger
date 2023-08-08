package com.onermorkoc.messenger.view.componets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SimpleHeader(text: String) {
    Text(
        text = text,
        style = TextStyle(fontSize = 34.sp),
        modifier = Modifier.padding(start = 16.dp, top = 8.dp)
    )
}

@Composable
fun BackButtonHeader(text: String, onClick: () -> Unit) {
    Row {
        IconButton(
            onClick = { onClick() },
            modifier = Modifier.size(50.dp)
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = null,
                modifier = Modifier.size(50.dp),
                tint = MaterialTheme.colorScheme.primary
            )
        }
        Text(
            text = text,
            style = TextStyle(fontSize = 34.sp)
        )
    }
}