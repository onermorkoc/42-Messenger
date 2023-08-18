package com.onermorkoc.messenger.viewmodel

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.onermorkoc.messenger.common.Contants
import com.onermorkoc.messenger.utils.languages.Languages
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginScreenVM @Inject constructor(val languagesImpl: Languages): ViewModel() {

    fun getGoogleIntent(activity: Activity): Intent {

        val gso = GoogleSignInOptions.Builder()
        .requestIdToken(Contants.Env.GOOGLE_API_KEY)
        .requestEmail()
        .build()

        val gsc = GoogleSignIn.getClient(activity, gso)
        return gsc.signInIntent
    }
}