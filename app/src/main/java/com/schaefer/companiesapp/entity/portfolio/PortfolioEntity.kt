package com.schaefer.companiesapp.entity.portfolio

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class PortfolioEntity(
    @SerializedName("enterprises_number") val enterprises_number: Int,
    @SerializedName("enterprises") val enterprises: List<String>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.createStringArrayList()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(enterprises_number)
        parcel.writeStringList(enterprises)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PortfolioEntity> {
        override fun createFromParcel(parcel: Parcel): PortfolioEntity {
            return PortfolioEntity(parcel)
        }

        override fun newArray(size: Int): Array<PortfolioEntity?> {
            return arrayOfNulls(size)
        }
    }
}