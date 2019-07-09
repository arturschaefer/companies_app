package com.schaefer.companiesapp.di.module

import com.schaefer.companiesapp.view.HomeActivity
import dagger.Module
import dagger.Provides

@Module
class HomeModule(private val homeActivity: HomeActivity) {
    @Provides
    fun providesHomeActivity(): HomeActivity = homeActivity
}