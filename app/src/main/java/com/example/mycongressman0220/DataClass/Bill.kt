package com.example.mycongressman0220.DataClass

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable

data class Bill(
    var billID: String,
    var dataTitle:String,
    var title:String,
    var date:String,
    var link:String,
    var content:String,
    var coactor:String,
    var if_processed:Boolean
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    @SuppressLint("NewApi")
    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeString(billID)
        p0?.writeString(dataTitle)
        p0?.writeString(title)
        p0?.writeString(date)
        p0?.writeString(link)
        p0?.writeString(content)
        p0?.writeString(coactor)
        p0?.writeBoolean(this.if_processed)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Bill> {
        override fun createFromParcel(parcel: Parcel): Bill {
            return Bill(parcel)
        }

        override fun newArray(size: Int): Array<Bill?> {
            return arrayOfNulls(size)
        }
    }
}