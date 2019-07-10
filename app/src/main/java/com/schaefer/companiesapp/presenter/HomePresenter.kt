package com.schaefer.companiesapp.presenter

import com.orhanobut.logger.Logger
import com.schaefer.companiesapp.R
import com.schaefer.companiesapp.entity.enterprise.Enterprise
import com.schaefer.companiesapp.entity.login.LoginResultEntity
import com.schaefer.companiesapp.interactor.HomeInteractor
import com.schaefer.companiesapp.router.goToDetailScreen
import com.schaefer.companiesapp.view.HomeActivity
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class HomePresenter @Inject constructor(
    private val view: HomeActivity,
    private val interactor: HomeInteractor
) {
    private val EXTRA_LOGIN_RESULT = "loginResult"

    private var loginResultEntity: LoginResultEntity? = null
    private var enterprises: List<Enterprise>? = null

    private var disposable: Disposable? = null
    fun disposeCalls() {
        if (disposable != null && disposable?.isDisposed == false) {
            disposable?.dispose()
        }
    }

    fun getEnterprisesByName(name: String) {
        if (name.isNotEmpty()) {
            disposable = loginResultEntity?.credentialsEntity?.accessToken?.let { accessToken ->
                loginResultEntity?.credentialsEntity?.client?.let { client ->
                    loginResultEntity?.credentialsEntity?.uid?.let { uid ->
                        interactor
                            .getEnterprisesByName(
                                name,
                                accessToken,
                                client,
                                uid
                            )
                            .subscribe({
                                enterprises = it?.enterprises
                                view.successGetEnterprises(it)
                            }, { e ->
                                Logger.e(e.message.toString())
                                view.showMessageError(view.getString(R.string.error_get_enterprises))
                            })
                    }
                }
            }
        } else {
            view.showMessageError(view.getString(R.string.error_email_password))
        }
    }

    fun getIntentValues() {
        val intent = view.intent
        loginResultEntity = intent.getParcelableExtra<LoginResultEntity>(EXTRA_LOGIN_RESULT)
    }

    fun onClickOnItem(position: Int) {
        enterprises?.get(position)?.let { goToDetailScreen(view, it) }
    }
}