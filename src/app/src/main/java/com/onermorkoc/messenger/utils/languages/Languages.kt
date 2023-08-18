package com.onermorkoc.messenger.utils.languages

import android.content.Context

interface Languages {

    var supportedLanguages: ArrayList<String>

    fun getCurrentLanguageIndex(): Int
    fun setDefaultLanguage()
    fun changeLanguage(language: String, updateSP: Boolean = true, context: Context)
    fun applyLanguage(context: Context)
}