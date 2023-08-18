package com.onermorkoc.messenger.di

import android.content.Context
import android.content.SharedPreferences
import com.onermorkoc.messenger.utils.languages.Languages
import com.onermorkoc.messenger.utils.languages.LanguagesImpl
import com.onermorkoc.messenger.utils.nightmode.NightMode
import com.onermorkoc.messenger.utils.nightmode.NightModeImpl
import com.onermorkoc.messenger.viewmodel.LoginScreenVM
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun getContext(@ApplicationContext context: Context): Context {
        return context
    }

    @Provides
    @Singleton
    fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences("42-messenger", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun getNightModeImpl(sharedPreferences: SharedPreferences): NightMode {
        return NightModeImpl(sharedPreferences)
    }

    @Provides
    @Singleton
    fun getLanguagesImpl(sharedPreferences: SharedPreferences): Languages {
        return LanguagesImpl(sharedPreferences)
    }

    @Provides
    @Singleton
    fun getLoginScreenVm(languagesImpl: Languages): LoginScreenVM {
        return LoginScreenVM(languagesImpl)
    }
}