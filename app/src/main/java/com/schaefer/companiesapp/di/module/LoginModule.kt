package com.schaefer.companiesapp.di.module

import com.schaefer.companiesapp.view.LoginActivity
import dagger.Module
import dagger.Provides

@Module
class LoginModule(private val loginActivity: LoginActivity) {
    @Provides
    fun providesLoginActivity(): LoginActivity = loginActivity
}