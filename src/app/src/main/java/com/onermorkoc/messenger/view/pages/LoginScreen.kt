package com.onermorkoc.messenger.view.pages

import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.onermorkoc.messenger.R
import com.onermorkoc.messenger.navigation.Routes
import com.onermorkoc.messenger.view.componets.MLanguagesPopup
import com.onermorkoc.messenger.viewmodel.LoginScreenVM

@Composable
fun LoginScreen(activity: Activity, nightMode: () -> Unit, navigate: (routes: Routes) -> Unit) {

    var languagesVisibility by remember { mutableStateOf(false) }
    val loginScreenVm: LoginScreenVM = hiltViewModel()
    val context = LocalContext.current

    val activityResult = rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) {

        if (it.resultCode == Activity.RESULT_OK) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
            task.addOnSuccessListener {
                println(it)
            }.addOnFailureListener {
                Toast.makeText(context, it.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(context, context.getString(R.string.fail), Toast.LENGTH_SHORT).show()
        }
    }

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
                    modifier = Modifier
                        .padding(top = 16.dp, end = 16.dp)
                        .height(125.dp)
                ) {
                    FilledIconButton(
                        onClick = { languagesVisibility = true },
                        modifier = Modifier.size(53.dp),
                        colors = IconButtonDefaults.iconButtonColors(containerColor = Color.Transparent)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.language),
                            contentDescription = null,
                            modifier = Modifier.size(45.dp)
                        )
                    }
                    FilledIconButton(
                        onClick = { nightMode() },
                        modifier = Modifier.size(56.dp),
                        colors = IconButtonDefaults.iconButtonColors(containerColor = Color.Transparent)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.night),
                            contentDescription = null,
                            modifier = Modifier.size(48.dp)
                        )
                    }
                }
            }
            LoginAnimation()
            Text(
                text = stringResource(id = R.string.homeScreenText),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(start = 32.dp, end = 32.dp)
            )
            LoginButton {
                // activityResult.launch(loginScreenVm.getGoogleIntent(activity))
                navigate(Routes.HomeScreen)
            }
            MLanguagesPopup(visibility = languagesVisibility, languagesImpl = loginScreenVm.languagesImpl) {
                languagesVisibility = false
            }
        }
    }
}

@Composable
private fun LoginButton(onClick: () -> Unit) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = { onClick() },
            modifier = Modifier
                .height(50.dp)
                .width(200.dp)
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
    //_42MessengerTheme {
        // LoginScreen()
    //}
}