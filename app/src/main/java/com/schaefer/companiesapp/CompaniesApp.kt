package com.schaefer.companiesapp

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.schaefer.companiesapp.di.component.ApplicationComponent
import com.schaefer.companiesapp.di.component.DaggerApplicationComponent
import com.schaefer.companiesapp.di.module.ApplicationModule


class CompaniesApp : Application() {
    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(applicationContext))
            .build()
        Logger.addLogAdapter(AndroidLogAdapter())
    }

    fun getApplicationComponent(): ApplicationComponent {
        return applicationComponent
    }
}