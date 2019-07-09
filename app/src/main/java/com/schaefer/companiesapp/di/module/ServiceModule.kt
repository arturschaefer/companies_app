package com.schaefer.companiesapp.di.module

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.schaefer.companiesapp.BuildConfig
import com.schaefer.companiesapp.interactor.service.CompaniesInterceptor
import com.schaefer.companiesapp.interactor.service.CompaniesService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class ServiceModule {
    @Provides
    fun providesLoginService(): CompaniesService {
        val BASE_URL = "http://empresas.ioasys.com.br/api/v1/"
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val interceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            interceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            interceptor.level = HttpLoggingInterceptor.Level.BASIC
        }
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(0, TimeUnit.SECONDS)
            .readTimeout(0, TimeUnit.SECONDS)
            .writeTimeout(0, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(OkHttpClient.Builder().addInterceptor(CompaniesInterceptor).build())
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(CompaniesService::class.java)
    }
}