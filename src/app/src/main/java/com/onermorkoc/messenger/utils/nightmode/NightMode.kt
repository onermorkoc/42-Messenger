package com.onermorkoc.messenger.utils.nightmode

interface NightMode {
    fun setDefaultMode(mod: Boolean)
    fun statusMode(): Boolean
    fun changeMode(): Boolean
}