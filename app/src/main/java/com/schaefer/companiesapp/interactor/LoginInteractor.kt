package com.schaefer.companiesapp.interactor

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
            .map { it }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}