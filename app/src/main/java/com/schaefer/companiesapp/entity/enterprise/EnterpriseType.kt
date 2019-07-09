package com.schaefer.companiesapp.entity.enterprise

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class EnterpriseType(
    @SerializedName("id") val id: Int,
    @SerializedName("enterprise_type_name") val name: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<EnterpriseType> {
        override fun createFromParcel(parcel: Parcel): EnterpriseType {
            return EnterpriseType(parcel)
        }

        override fun newArray(size: Int): Array<EnterpriseType?> {
            return arrayOfNulls(size)
        }
    }
}