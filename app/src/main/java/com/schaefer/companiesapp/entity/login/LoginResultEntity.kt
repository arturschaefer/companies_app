package com.schaefer.companiesapp.entity.login

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.schaefer.companiesapp.entity.credentials.CredentialsEntity
import com.schaefer.companiesapp.entity.investor.InvestorEntity

data class LoginResultEntity(
    @SerializedName("investor") val investor: InvestorEntity,
    @SerializedName("enterprise") val enterprise: String?,
    @SerializedName("success") val success: Boolean,
    @SerializedName("credentials") var credentialsEntity: CredentialsEntity
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(InvestorEntity::class.java.classLoader),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readParcelable(CredentialsEntity::class.java.classLoader)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(investor, flags)
        parcel.writeString(enterprise)
        parcel.writeByte(if (success) 1 else 0)
        parcel.writeParcelable(credentialsEntity, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LoginResultEntity> {
        override fun createFromParcel(parcel: Parcel): LoginResultEntity {
            return LoginResultEntity(parcel)
        }

        override fun newArray(size: Int): Array<LoginResultEntity?> {
            return arrayOfNulls(size)
        }
    }

}