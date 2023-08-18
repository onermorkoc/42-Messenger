package com.onermorkoc.messenger.utils.nightmode

import android.content.SharedPreferences

class NightModeImpl (private val sharedPreferences: SharedPreferences): NightMode {

    private fun putSP(mod: String) { // on veya off
        sharedPreferences.edit().putString("night-mode", mod).apply()
    }

    override fun setDefaultMode(mod: Boolean) { // uygulama telefona ilk çalıştığında telefon default night modu al
        if (sharedPreferences.getString("night-mode", null) == null)
            if (mod) putSP("on") else putSP("off")
    }

    override fun statusMode(): Boolean {
        if (sharedPreferences.getString("night-mode", "") == "on")
            return true
        return false
    }

    override fun changeMode(): Boolean {
        if (statusMode())
            putSP("off")
        else
            putSP("on")
        return statusMode()
    }
}