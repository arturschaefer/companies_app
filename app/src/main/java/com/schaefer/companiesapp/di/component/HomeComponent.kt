package com.schaefer.companiesapp.di.component

import com.schaefer.companiesapp.di.module.HomeModule
import com.schaefer.companiesapp.view.HomeActivity
import dagger.Component

@Component(modules = [HomeModule::class], dependencies = [ApplicationComponent::class])
interface HomeComponent {
    fun inject(homeActivity: HomeActivity)
}