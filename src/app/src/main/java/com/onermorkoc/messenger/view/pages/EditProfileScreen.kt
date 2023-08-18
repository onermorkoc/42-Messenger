package com.onermorkoc.messenger.view.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.onermorkoc.messenger.R
import com.onermorkoc.messenger.navigation.Routes
import com.onermorkoc.messenger.view.componets.BackButtonHeader
import com.onermorkoc.messenger.view.componets.MActionButton
import com.onermorkoc.messenger.view.componets.MTextField

@Composable
fun EditProfileScreen(navigate: (routes: Routes) -> Unit) {

    Box(modifier = Modifier.fillMaxSize()) {

        Column {
            BackButtonHeader(text = stringResource(id = R.string.profile)) {

            }
            ProfilePhoto(null)
            TextFields()
            MActionButton(painter = painterResource(id = R.drawable.check)) {

            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun ProfilePhoto(url: String?) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth().height(235.dp).padding(top = 35.dp)
    ){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.size(200.dp)
        ){
            GlideImage(
                model = "https://lavinya.net/wp-content/uploads/2022/11/4c62ba-manzara-gol-lake-landscape-scaled.jpeg",
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            ){
                it.placeholder(R.drawable.loading).circleCrop()
            }
            Box(contentAlignment = Alignment.BottomEnd, modifier = Modifier.fillMaxSize()) {
                IconButton(
                    onClick = {},
                    modifier = Modifier.size(30.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.image_galery),
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Composable
private fun TextFields() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.8f)
            .padding(top = 35.dp)
    ) {

        MTextField(
            maxLines = 1,
            label = stringResource(id = R.string.fullname),
            hint = stringResource(id = R.string.fullname_hint),
            modifier = Modifier.fillMaxWidth(0.75f)
        ) {
            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
        }

        MTextField(
            maxLines = 1,
            label = stringResource(id = R.string.nickname),
            hint = stringResource(id = R.string.nickname_hint),
            modifier = Modifier
                .fillMaxWidth(0.75f)
                .padding(top = 16.dp)
        ) {
            Icon(imageVector = Icons.Default.Edit, contentDescription = null)
        }

        MTextField(
            maxLines = 5,
            label = stringResource(id = R.string.about),
            hint = stringResource(id = R.string.about_hint),
            modifier = Modifier
                .fillMaxWidth(0.75f)
                .padding(top = 16.dp)
        ) {
            Icon(painter = painterResource(id = R.drawable.text), contentDescription = null)
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
private fun EditProfileScreenPreview() {
    //_42MessengerTheme {
        // EditProfileScreen()
    //}
}