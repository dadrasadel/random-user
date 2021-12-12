package com.globallogic.pokemon

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp

class Pokomon : Application() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }





}