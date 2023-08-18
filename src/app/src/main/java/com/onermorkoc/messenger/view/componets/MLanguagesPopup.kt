package com.onermorkoc.messenger.view.componets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.onermorkoc.messenger.R
import com.onermorkoc.messenger.utils.languages.Languages

@Composable
fun MLanguagesPopup(visibility: Boolean, languagesImpl: Languages, changeVisibility: () -> Unit) {

    var selectedItem by remember { mutableStateOf(languagesImpl.getCurrentLanguageIndex()) }
    val context = LocalContext.current

    if (visibility) {
        Dialog(onDismissRequest = { changeVisibility() }) {
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.lang),
                        style = TextStyle(fontSize = 40.sp)
                    )
                    Divider()
                    LazyColumn {
                        items(languagesImpl.supportedLanguages){ item ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Checkbox(
                                    checked = selectedItem == languagesImpl.supportedLanguages.indexOf(item),
                                    onCheckedChange = {
                                        selectedItem = languagesImpl.supportedLanguages.indexOf(item)
                                        languagesImpl.changeLanguage(item, context = context)
                                        changeVisibility()
                                    }
                                )
                                Text(
                                    text = item.uppercase(),
                                    style = TextStyle(fontSize = 18.sp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}