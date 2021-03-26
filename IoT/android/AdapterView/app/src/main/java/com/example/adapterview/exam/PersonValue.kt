package com.example.adapterview.exam

import android.os.Parcel
import android.os.Parcelable

class PersonValue() : Parcelable {
    var myImg = 0
    var name: String? = null
    var date: String? = null
    var info: String? = null

    constructor(parcel: Parcel) : this() {
        myImg = parcel.readInt()
        name = parcel.readString()
        date = parcel.readString()
        info = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(myImg)
        parcel.writeString(name)
        parcel.writeString(date)
        parcel.writeString(info)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PersonValue> {
        override fun createFromParcel(parcel: Parcel): PersonValue {
            return PersonValue(parcel)
        }

        override fun newArray(size: Int): Array<PersonValue?> {
            return arrayOfNulls(size)
        }
    }


}