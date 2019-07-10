package com.schaefer.companiesapp.entity.investor

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.schaefer.companiesapp.entity.portfolio.PortfolioEntity

data class InvestorEntity(
    @SerializedName("id") val id: Int,
    @SerializedName("investor_name") val investor_name: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("city") val city: String?,
    @SerializedName("country") val country: String?,
    @SerializedName("balance") val balance: Int,
    @SerializedName("photo") val photo: String?,
    @SerializedName("portfolio") val portfolio: PortfolioEntity,
    @SerializedName("portfolio_value") val portfolio_value: Int,
    @SerializedName("first_access") val first_access: Boolean,
    @SerializedName("super_angel") val super_angel: Boolean
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readParcelable(PortfolioEntity::class.java.classLoader),
        parcel.readInt(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(investor_name)
        parcel.writeString(email)
        parcel.writeString(city)
        parcel.writeString(country)
        parcel.writeInt(balance)
        parcel.writeString(photo)
        parcel.writeParcelable(portfolio, flags)
        parcel.writeInt(portfolio_value)
        parcel.writeByte(if (first_access) 1 else 0)
        parcel.writeByte(if (super_angel) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<InvestorEntity> {
        override fun createFromParcel(parcel: Parcel): InvestorEntity {
            return InvestorEntity(parcel)
        }

        override fun newArray(size: Int): Array<InvestorEntity?> {
            return arrayOfNulls(size)
        }
    }

}