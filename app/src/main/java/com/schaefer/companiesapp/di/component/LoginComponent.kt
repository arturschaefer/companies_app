package com.schaefer.companiesapp.di.component

import com.schaefer.companiesapp.di.module.LoginModule
import com.schaefer.companiesapp.view.LoginActivity
import dagger.Component

@Component(modules = [LoginModule::class], dependencies = [ApplicationComponent::class])
interface LoginComponent {
    fun inject(loginActivity: LoginActivity)
}