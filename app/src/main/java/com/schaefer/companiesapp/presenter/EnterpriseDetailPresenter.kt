package com.schaefer.companiesapp.presenter

import com.schaefer.companiesapp.entity.enterprise.Enterprise
import com.schaefer.companiesapp.interactor.EnterpriseDetailInteractor
import com.schaefer.companiesapp.view.EnterpriseDetailActivity
import javax.inject.Inject

class EnterpriseDetailPresenter @Inject constructor(
    private val view: EnterpriseDetailActivity,
    private val interactor: EnterpriseDetailInteractor
) {
    private val EXTRA_ENTEPRISE_DETAIL = "enterprise_detail"
    fun getIntentValues() {
        val intent = view.intent
        val enterpriseDetail = intent.getParcelableExtra<Enterprise>(EXTRA_ENTEPRISE_DETAIL)
        view.setDetails(enterpriseDetail)
    }
}