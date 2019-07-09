package com.schaefer.companiesapp.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.orhanobut.logger.Logger
import com.schaefer.companiesapp.R
import com.schaefer.companiesapp.entity.utils.Utils.changeColorStatusBar
import com.schaefer.companiesapp.entity.utils.Utils.enableButton
import com.schaefer.companiesapp.presenter.LoginPresenter
import com.schaefer.companiesapp.view.utils.loginActivityComponent
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {
    private var toast: Toast? = null
    @Inject
    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginActivityComponent.inject(this)

        enableButton(false, button_sign_in)

        changeColorStatusBar(window, this, R.color.black_opacity)

        button_sign_in.setOnClickListener {
            Logger.d("test")
            presenter.signIn(edittext_email.text.toString(), editText_password.text.toString())
        }
        edittext_email.addTextChangedListener(emailTextWatcher)
    }

    fun showMessageError(message: String) {
        toast = Toast.makeText(this, message, Toast.LENGTH_LONG)
        toast?.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.disposeCalls()
    }

    private val emailTextWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            presenter.validateEmail(s.toString(), button_sign_in)
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }
    }
}