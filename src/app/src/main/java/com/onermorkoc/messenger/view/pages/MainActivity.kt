package com.onermorkoc.messenger.view.pages

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.onermorkoc.messenger.navigation.NavGraph
import com.onermorkoc.messenger.ui.theme._42MessengerTheme
import com.onermorkoc.messenger.utils.languages.Languages
import com.onermorkoc.messenger.utils.nightmode.NightMode
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject lateinit var nightModeImpl: NightMode
    @Inject lateinit var languagesImpl: Languages

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            nightModeImpl.setDefaultMode(isSystemInDarkTheme())
            var nightModeState by remember { mutableStateOf(nightModeImpl.statusMode()) }
            languagesImpl.setDefaultLanguage()
            val context = LocalContext.current
            languagesImpl.applyLanguage(context)

            _42MessengerTheme(darkTheme = nightModeState) {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    NavGraph(activity = this) {
                        nightModeState = nightModeImpl.changeMode()
                    }
                }
            }
        }
    }
}