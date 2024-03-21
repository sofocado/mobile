package com.example.restaurantapp.models

import android.os.Parcel
import android.os.Parcelable

data class Row(
    val __v: Int,
    val _id: String,
    val address: String,
    val countTable: Int,
    val description: String,
    val name: String,
    val rid: String
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(__v)
        parcel.writeString(_id)
        parcel.writeString(address)
        parcel.writeInt(countTable)
        parcel.writeString(description)
        parcel.writeString(name)
        parcel.writeString(rid)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Row> {
        override fun createFromParcel(parcel: Parcel): Row {
            return Row(parcel)
        }

        override fun newArray(size: Int): Array<Row?> {
            return arrayOfNulls(size)
        }
    }
}