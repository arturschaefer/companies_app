package com.schaefer.companiesapp.view.utils

import android.app.Activity
import com.schaefer.companiesapp.CompaniesApp
import com.schaefer.companiesapp.di.component.*
import com.schaefer.companiesapp.di.module.EnterpriseDetailModule
import com.schaefer.companiesapp.di.module.HomeModule
import com.schaefer.companiesapp.di.module.LoginModule
import com.schaefer.companiesapp.view.EnterpriseDetailActivity
import com.schaefer.companiesapp.view.HomeActivity
import com.schaefer.companiesapp.view.LoginActivity

val Activity.applicationComponent get() = (application as CompaniesApp).getApplicationComponent()
val LoginActivity.loginActivityComponent: LoginComponent
    get() = DaggerLoginComponent
        .builder()
        .applicationComponent(applicationComponent)
        .loginModule(LoginModule(this))
        .build()
val HomeActivity.homeActivityComponent: HomeComponent
    get() = DaggerHomeComponent
        .builder()
        .applicationComponent(applicationComponent)
        .homeModule(HomeModule(this))
        .build()
val EnterpriseDetailActivity.enterpriseDetailComponent: EnterpriseDetailComponent
    get() = DaggerEnterpriseDetailComponent
        .builder()
        .applicationComponent(applicationComponent)
        .enterpriseDetailModule(EnterpriseDetailModule(this))
        .build()