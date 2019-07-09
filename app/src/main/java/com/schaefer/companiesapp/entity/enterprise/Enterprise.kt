package com.schaefer.companiesapp.entity.enterprise

import com.google.gson.annotations.SerializedName

data class Enterprise(
    @SerializedName("id") val id: Int,
    @SerializedName("email_enterprise") val email_enterprise: String,
    @SerializedName("facebook") val facebook: String,
    @SerializedName("twitter") val twitter: String,
    @SerializedName("linkedin") val linkedin: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("own_enterprise") val own_enterprise: Boolean,
    @SerializedName("enterprise_name") val enterprise_name: String,
    @SerializedName("photo") val photo: String,
    @SerializedName("description") val description: String,
    @SerializedName("city") val city: String,
    @SerializedName("country") val country: String,
    @SerializedName("value") val value: Int,
    @SerializedName("share_price") val share_price: Int,
    @SerializedName("enterprise_type") val enterpriseType: EnterpriseType
)