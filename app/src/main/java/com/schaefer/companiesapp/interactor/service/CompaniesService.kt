package com.schaefer.companiesapp.interactor.service

import com.schaefer.companiesapp.entity.enterprise.Enterprises
import com.schaefer.companiesapp.entity.login.LoginEntity
import com.schaefer.companiesapp.entity.login.LoginResultEntity
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.*

interface CompaniesService {
    @POST("users/auth/sign_in")
    fun signIn(@Body loginBody: LoginEntity): Observable<Response<LoginResultEntity>>

    @GET("enterprises")
    fun getEnterprisesByName(
        @Header("access-token") accessToken: String?,
        @Header("client") client: String?,
        @Header("uid") uid: String?,
        @Query("name") name: String?
    ): Observable<Response<Enterprises>>

    /*@GET("enterprises/{id}")
    fun showAsync(@Path("id") id: Int): Deferred<EnterpriseShowResponse>*/
}