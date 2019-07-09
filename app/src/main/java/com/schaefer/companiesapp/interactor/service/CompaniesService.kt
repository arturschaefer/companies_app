package com.schaefer.companiesapp.interactor.service

import com.schaefer.companiesapp.entity.enterprise.Enterprises
import com.schaefer.companiesapp.entity.login.LoginEntity
import com.schaefer.companiesapp.entity.login.LoginResultEntity
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface CompaniesService {
    @POST("users/auth/sign_in")
    fun signIn(@Body loginBody: LoginEntity): Observable<LoginResultEntity>

    @GET("enterprises")
    fun searchEnterprises(@Query("name") name: String?): Observable<Enterprises>

    /*@GET("enterprises/{id}")
    fun showAsync(@Path("id") id: Int): Deferred<EnterpriseShowResponse>*/
}