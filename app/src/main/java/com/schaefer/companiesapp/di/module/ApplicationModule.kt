package com.schaefer.companiesapp.di.module

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val context: Context) {
    @Provides
    fun providesContext(): Context = context
}