package com.schaefer.companiesapp.entity.enterprise

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Enterprise(
    @SerializedName("id") val id: Int,
    @SerializedName("email_enterprise") val email_enterprise: String?,
    @SerializedName("facebook") val facebook: String?,
    @SerializedName("twitter") val twitter: String?,
    @SerializedName("linkedin") val linkedin: String?,
    @SerializedName("phone") val phone: String?,
    @SerializedName("own_enterprise") val own_enterprise: Boolean,
    @SerializedName("enterprise_name") val enterprise_name: String?,
    @SerializedName("photo") val photo: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("city") val city: String?,
    @SerializedName("country") val country: String?,
    @SerializedName("value") val value: Int,
    @SerializedName("share_price") val share_price: Int,
    @SerializedName("enterprise_type") val enterpriseType: EnterpriseType
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readParcelable(EnterpriseType::class.java.classLoader)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(email_enterprise)
        parcel.writeString(facebook)
        parcel.writeString(twitter)
        parcel.writeString(linkedin)
        parcel.writeString(phone)
        parcel.writeByte(if (own_enterprise) 1 else 0)
        parcel.writeString(enterprise_name)
        parcel.writeString(photo)
        parcel.writeString(description)
        parcel.writeString(city)
        parcel.writeString(country)
        parcel.writeInt(value)
        parcel.writeInt(share_price)
        parcel.writeParcelable(enterpriseType, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Enterprise> {
        override fun createFromParcel(parcel: Parcel): Enterprise {
            return Enterprise(parcel)
        }

        override fun newArray(size: Int): Array<Enterprise?> {
            return arrayOfNulls(size)
        }
    }

}