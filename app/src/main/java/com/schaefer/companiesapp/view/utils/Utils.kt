package com.schaefer.companiesapp.view.utils

import android.app.Activity
import com.schaefer.companiesapp.CompaniesApp
import com.schaefer.companiesapp.di.component.DaggerLoginComponent
import com.schaefer.companiesapp.di.component.LoginComponent
import com.schaefer.companiesapp.di.module.LoginModule
import com.schaefer.companiesapp.view.LoginActivity

val Activity.applicationComponent get() = (application as CompaniesApp).getApplicationComponent()
val LoginActivity.loginActivityComponent: LoginComponent
    get() = DaggerLoginComponent
        .builder()
        .applicationComponent(applicationComponent)
        .loginModule(LoginModule(this))
        .build()