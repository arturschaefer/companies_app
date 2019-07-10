package com.schaefer.companiesapp.di.component

import com.schaefer.companiesapp.di.module.EnterpriseDetailModule
import com.schaefer.companiesapp.view.EnterpriseDetailActivity
import dagger.Component


@Component(modules = [EnterpriseDetailModule::class], dependencies = [ApplicationComponent::class])
interface EnterpriseDetailComponent {
    fun inject(enterpriseDetailActivity: EnterpriseDetailActivity)
}