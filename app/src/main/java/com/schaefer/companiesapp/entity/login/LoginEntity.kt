package com.schaefer.companiesapp.entity.login

import com.google.gson.annotations.SerializedName

data class LoginEntity(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("email") val email: String? = null,
    @SerializedName("password") val password: String? = null
)