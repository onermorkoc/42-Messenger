package com.onermorkoc.messenger.view.pages

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.onermorkoc.messenger.R
import com.onermorkoc.messenger.ui.theme._42MessengerTheme
import com.onermorkoc.messenger.view.componets.MActionButton
import com.onermorkoc.messenger.view.componets.MSearchBar
import com.onermorkoc.messenger.view.componets.SimpleHeader
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(navController: NavHostController) {

    val chatsText = stringResource(id = R.string.chats)
    var headerText by remember { mutableStateOf(chatsText) }
    val pagerState =  rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            SimpleHeader(text = headerText)
            Menu()
        }
        MSearchBar()
        PaperButtons(pagerState) { text, id ->
            headerText = text
            coroutineScope.launch {
                pagerState.scrollToPage(id)
            }
        }
        Papers(pagerState) { headerText = it }
        MActionButton(painter = painterResource(id = R.drawable.chat_bubble)) {
            navController.navigate("ContactsScreen")
        }
    }
}

@Composable
private fun Menu(){

    var expand by remember { mutableStateOf(false) }

    Box(modifier = Modifier.padding(end = 8.dp)) {

        IconButton(onClick = { expand = !expand }) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
        }

        DropdownMenu(
            expanded = expand,
            onDismissRequest = { expand = false }
        ) {
            DropdownMenuItem(
                text = {
                    Row {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = null
                        )
                        Text(
                            text = stringResource(id = R.string.settings),
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                },
                onClick = {
                          // Ayarlara git
                },
                modifier = Modifier
                    .height(35.dp)
                    .width(150.dp)
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun PaperButtons(pagerState: PagerState, onClick: (text: String, pageId: Int) -> Unit) {

    val chatsText = stringResource(id = R.string.chats)
    val groupsText = stringResource(id = R.string.groups)
    val statusText = stringResource(id = R.string.status)

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
    ) {

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .weight(1f)
                .clickable {
                    onClick(chatsText, 0)
                }
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.chats),
                contentDescription = null,
                modifier = Modifier.size(32.dp),
                colorFilter = if (pagerState.currentPage == 0) ColorFilter.tint(MaterialTheme.colorScheme.primary) else null
            )
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .weight(1f)
                .clickable {
                    onClick(groupsText, 1)
                }
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.groups),
                contentDescription = null,
                modifier = Modifier.size(32.dp),
                colorFilter = if (pagerState.currentPage == 1) ColorFilter.tint(MaterialTheme.colorScheme.primary) else null
            )
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .weight(1f)
                .clickable {
                    onClick(statusText, 2)
                }
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.status),
                contentDescription = null,
                modifier = Modifier.size(32.dp),
                colorFilter = if (pagerState.currentPage == 2) ColorFilter.tint(MaterialTheme.colorScheme.primary) else null
            )
        }
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun Papers(pagerState: PagerState, onChange: (text: String) -> Unit){

    val chatsText = stringResource(id = R.string.chats)
    val groupsText = stringResource(id = R.string.groups)
    val statusText = stringResource(id = R.string.status)

    HorizontalPager(
        pageCount = 3,
        state = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.85f)
    ) {
        when (pagerState.currentPage) {
            0-> {
                ChatsPaper()
                onChange(chatsText)
            }
            1-> {
                GroupsPaper()
                onChange(groupsText)
            }
            else -> {
                StatusPaper()
                onChange(statusText)
            }
        }
    }
}

@Composable
private fun ChatsPaper() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "Chats ekran")
    }
}

@Composable
private fun GroupsPaper() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "Groups ekran")
    }
}

@Composable
private fun StatusPaper() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "Status ekran")
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true) 
private fun HomeScreenPreview(){
    _42MessengerTheme {
        // HomeScreen()
    }    
}