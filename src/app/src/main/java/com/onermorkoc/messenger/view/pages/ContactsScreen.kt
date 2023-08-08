package com.onermorkoc.messenger.view.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.onermorkoc.messenger.R
import com.onermorkoc.messenger.ui.theme._42MessengerTheme
import com.onermorkoc.messenger.view.componets.BackButtonHeader
import com.onermorkoc.messenger.view.componets.MActionButton
import com.onermorkoc.messenger.view.componets.MSearchBar

@Composable
fun ContactsScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier.fillMaxSize()) {
            BackButtonHeader(text = stringResource(id = R.string.contacts)) {
                navController.navigate("HomeScreen")
            }
            MSearchBar()
            Buttons()
            ContactsList()
            MActionButton(painter = painterResource(id = R.drawable.add_friend)) {
                // kişi ekleme
            }
        }
    }
}

@Composable
private fun Buttons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Button(
            onClick = {},
            modifier = Modifier.height(50.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.create_group),
                contentDescription = null
            )
            Text(
                text = stringResource(id = R.string.create_group),
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Button(
            onClick = {},
            modifier = Modifier.height(50.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.join_group),
                contentDescription = null
            )
            Text(
                text = stringResource(id = R.string.join_group),
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}

@Composable
private fun ContactsList() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.85f)
    ) {

    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun ContactsScreenPreview() {
    _42MessengerTheme {
        // ContactsScreen()
    }
}