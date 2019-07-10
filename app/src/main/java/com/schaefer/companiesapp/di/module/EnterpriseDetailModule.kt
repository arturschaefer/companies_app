package com.schaefer.companiesapp.di.module

import com.schaefer.companiesapp.view.EnterpriseDetailActivity
import dagger.Module
import dagger.Provides

@Module
class EnterpriseDetailModule(private val enterpriseDetailActivity: EnterpriseDetailActivity) {
    @Provides
    fun providesEnterpriseDetailActivity(): EnterpriseDetailActivity = enterpriseDetailActivity
}