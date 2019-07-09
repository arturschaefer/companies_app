package com.schaefer.companiesapp.presenter

import android.view.View
import com.orhanobut.logger.Logger
import com.schaefer.companiesapp.R
import com.schaefer.companiesapp.entity.login.LoginEntity
import com.schaefer.companiesapp.entity.utils.Utils.enableButton
import com.schaefer.companiesapp.entity.utils.Utils.isValidEmail
import com.schaefer.companiesapp.interactor.LoginInteractor
import com.schaefer.companiesapp.router.goToHomeScreen
import com.schaefer.companiesapp.view.LoginActivity
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class LoginPresenter @Inject constructor(
    private val view: LoginActivity,
    private val interactor: LoginInteractor
) {

    var disposable: Disposable? = null

    fun signIn(email: String, password: String) {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            disposable = interactor
                .signIn(LoginEntity(null, email, password))
                .subscribe({
                    it?.let {
                        goToHomeScreen(view, it)
                        view.finish()
                    }
                }, { e ->
                    Logger.e(e.message.toString())
                    view.showMessageError(view.getString(R.string.error_wrong_credentials))
                })
        } else {
            view.showMessageError(view.getString(R.string.error_email_password))
        }
    }

    fun disposeCalls() {
        if (disposable != null && disposable?.isDisposed == false) {
            disposable?.dispose()
        }
    }

    fun validateEmail(email: String, button: View) {
        enableButton(isValidEmail(email), button)
    }
}