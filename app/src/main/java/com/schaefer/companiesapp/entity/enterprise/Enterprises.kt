package com.schaefer.companiesapp.entity.enterprise

import com.google.gson.annotations.SerializedName

data class Enterprises(
    @SerializedName("enterprises") val enterprises: List<Enterprise>
)