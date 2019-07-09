package com.schaefer.companiesapp.interactor.service

import com.schaefer.companiesapp.entity.login.LoginEntity
import com.schaefer.companiesapp.entity.login.LoginResultEntity
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface CompaniesService {
    @POST("users/auth/sign_in")
    fun signIn(@Body loginBody: LoginEntity): Observable<LoginResultEntity>
}