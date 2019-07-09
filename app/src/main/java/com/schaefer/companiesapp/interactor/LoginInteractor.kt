package com.schaefer.companiesapp.interactor

import com.schaefer.companiesapp.entity.credentials.CredentialsEntity
import com.schaefer.companiesapp.entity.login.LoginEntity
import com.schaefer.companiesapp.entity.login.LoginResultEntity
import com.schaefer.companiesapp.interactor.service.CompaniesService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoginInteractor @Inject constructor(
    private val companiesService: CompaniesService
) {
    fun signIn(loginEntity: LoginEntity): Observable<LoginResultEntity?> {
        return companiesService.signIn(loginEntity)
            .map {
                if (it.isSuccessful) {
                    //Get credentials
                    val accessToken = it.headers().values("access-token")[0]
                    val client = it.headers().values("client")[0]
                    val uid = it.headers().values("uid")[0]
                    //Save credentials at a copy of body object
                    val loginResultEntity = it.body()
                    loginResultEntity.credentialsEntity =
                        CredentialsEntity(accessToken, client, uid)
                    loginResultEntity
                } else {
                    null
                }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}