package com.personalfinance.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PersonalFinanceApplication : Application() {
    
    override fun onCreate() {
        super.onCreate()
    }
}