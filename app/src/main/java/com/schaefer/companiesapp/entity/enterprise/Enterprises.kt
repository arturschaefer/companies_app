package com.schaefer.companiesapp.entity.enterprise

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Enterprises(
    @SerializedName("enterprises") val enterprises: List<Enterprise>
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.createTypedArrayList(Enterprise)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(enterprises)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Enterprises> {
        override fun createFromParcel(parcel: Parcel): Enterprises {
            return Enterprises(parcel)
        }

        override fun newArray(size: Int): Array<Enterprises?> {
            return arrayOfNulls(size)
        }
    }
}