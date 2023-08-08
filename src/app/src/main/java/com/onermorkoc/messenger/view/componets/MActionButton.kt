package com.onermorkoc.messenger.view.componets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun MActionButton(painter:Painter, onClick: () -> Unit) {
    Box (
        contentAlignment = Alignment.CenterEnd,
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 16.dp)
    ) {
        FloatingActionButton(
            onClick = { onClick() },
            modifier = Modifier.size(55.dp),
            shape = MaterialTheme.shapes.extraLarge,
            containerColor = MaterialTheme.colorScheme.primary
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
        }
    }
}