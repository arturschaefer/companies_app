package com.schaefer.companiesapp.entity.credentials

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class CredentialsEntity(
    @SerializedName("access-token") val accessToken: String,
    @SerializedName("client") val client: String,
    @SerializedName("uid") val uid: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(accessToken)
        parcel.writeString(client)
        parcel.writeString(uid)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CredentialsEntity> {
        override fun createFromParcel(parcel: Parcel): CredentialsEntity {
            return CredentialsEntity(parcel)
        }

        override fun newArray(size: Int): Array<CredentialsEntity?> {
            return arrayOfNulls(size)
        }
    }
}