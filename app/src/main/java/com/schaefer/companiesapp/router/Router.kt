package com.schaefer.companiesapp.router

import android.app.Activity
import android.content.Intent
import com.schaefer.companiesapp.entity.enterprise.Enterprise
import com.schaefer.companiesapp.entity.login.LoginResultEntity
import com.schaefer.companiesapp.view.EnterpriseDetailActivity
import com.schaefer.companiesapp.view.HomeActivity

private const val EXTRA_LOGIN_RESULT = "loginResult"
private val EXTRA_ENTEPRISE_DETAIL = "enterprise_detail"

fun goToHomeScreen(view: Activity, loginEntityResult: LoginResultEntity) {
    val intent = Intent(view, HomeActivity::class.java)
    intent.putExtra(EXTRA_LOGIN_RESULT, loginEntityResult)
    view.startActivity(intent)
}

fun goToDetailScreen(view: Activity, enterprise: Enterprise) {
    val intent = Intent(view, EnterpriseDetailActivity::class.java)
    intent.putExtra(EXTRA_ENTEPRISE_DETAIL, enterprise)
    view.startActivity(intent)
}