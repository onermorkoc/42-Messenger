package com.onermorkoc.messenger.utils.languages

import android.content.Context
import android.content.SharedPreferences
import java.util.Locale

class LanguagesImpl(private val sharedPreferences: SharedPreferences): Languages {

    override var supportedLanguages: ArrayList<String> = arrayListOf(
        "tr", "en" // yeni dil eklemesi burada yapılacak.
    )

    private fun putSP(language: String) {
        sharedPreferences.edit().putString("language", language).apply()
    }

    override fun getCurrentLanguageIndex(): Int {
        val currentLanguage = sharedPreferences.getString("language", "")
        return supportedLanguages.indexOf(currentLanguage)
    }

    override fun setDefaultLanguage() { // uygulama ilk çalıştırılınca telefon varsayılan dili kaydet
        if (sharedPreferences.getString("language", null) == null){

            val defaultLanguage = Locale.getDefault().language

            if (supportedLanguages.contains(defaultLanguage))
                putSP(defaultLanguage)
            else
                putSP("en") // eğer uygulama, telefon varsayılan dili desteklemiyorsa uygulama varsayılan dilini "en" olarak ayarla
        }
    }

    override fun changeLanguage(language: String, updateSP: Boolean, context: Context) {

        val locale = Locale(language)
        val displayMetrics = context.resources.displayMetrics
        val configuration = context.resources.configuration
        configuration.setLocale(locale)
        context.resources.updateConfiguration(configuration, displayMetrics)
        if (updateSP)
            putSP(language)
    }

    override fun applyLanguage(context: Context) {  // uygulama her açıldığında seçilen dili uygula
        changeLanguage(sharedPreferences.getString("language", "")!!, false, context)
    }
}