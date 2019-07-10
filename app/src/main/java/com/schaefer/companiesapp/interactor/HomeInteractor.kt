package com.schaefer.companiesapp.interactor

import com.schaefer.companiesapp.entity.enterprise.Enterprises
import com.schaefer.companiesapp.interactor.service.CompaniesService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeInteractor @Inject constructor(
    private val companiesService: CompaniesService
) {
    fun getEnterprisesByName(
        name: String,
        accessToken: String,
        client: String,
        uid: String
    ): Observable<Enterprises?> {
        return companiesService.getEnterprisesByName(accessToken, client, uid, name)
            .map {
                if (it.isSuccessful) {
                    it.body()
                } else {
                    null
                }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}