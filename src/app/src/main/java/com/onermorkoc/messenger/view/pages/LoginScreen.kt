package com.onermorkoc.messenger.view.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.onermorkoc.messenger.R
import com.onermorkoc.messenger.ui.theme._42MessengerTheme

@Composable
fun LoginScreen(navController: NavHostController) {

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = R.string.hello),
                    style = TextStyle(fontSize = 40.sp),
                    modifier = Modifier.padding(top = 30.dp, start = 30.dp)
                )
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.padding(top = 16.dp, end = 16.dp).height(125.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.language),
                        contentDescription = null,
                        modifier = Modifier.size(43.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.night),
                        contentDescription = null,
                        modifier = Modifier.size(48.dp)
                    )
                }
            }
            LoginAnimation()
            Text(
                text = stringResource(id = R.string.homeScreenText),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(start = 32.dp, end = 32.dp)
            )
            LoginButton(navController)
        }
    }
}

@Composable
private fun LoginButton(navController: NavHostController) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = { navController.navigate("HomeScreen") }, // Home Ekranına gitme
            modifier = Modifier.height(50.dp).width(200.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.google),
                contentDescription = null,
                modifier = Modifier.size(25.dp)
            )
            Text(
                text = stringResource(id = R.string.next),
                modifier = Modifier.padding(start = 8.dp),
                style = TextStyle(fontSize = 20.sp)
            )
        }
    }
}

@Composable
private fun LoginAnimation()  {

    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.home_screen))
    val progress by animateLottieCompositionAsState(composition = composition, iterations = LottieConstants.IterateForever)

    LottieAnimation(
        composition = composition,
        progress = { progress },
        modifier = Modifier.size(275.dp)
    )
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun LoginScreenPreview() {
    _42MessengerTheme {
        // LoginScreen()
    }
}