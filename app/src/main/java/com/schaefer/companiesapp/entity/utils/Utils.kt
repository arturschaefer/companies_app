package com.schaefer.companiesapp.entity.utils

import android.text.TextUtils
import android.util.Patterns
import android.view.View


object Utils {
    @JvmStatic
    fun isValidEmail(target: CharSequence): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }

    @JvmStatic
    fun enableButton(isEnabled: Boolean, view: View) {
        view.isEnabled = isEnabled
        if (isEnabled) {
            view.alpha = 1f
        } else {
            view.alpha = 0.3f
        }
    }
}