package com.schaefer.companiesapp.di.component

import android.content.Context
import com.schaefer.companiesapp.di.module.ApplicationModule
import com.schaefer.companiesapp.di.module.ServiceModule
import com.schaefer.companiesapp.interactor.service.CompaniesService
import dagger.Component

@Component(modules = [ApplicationModule::class, ServiceModule::class])
interface ApplicationComponent {
    fun getContext(): Context
    fun getLoginService(): CompaniesService
}