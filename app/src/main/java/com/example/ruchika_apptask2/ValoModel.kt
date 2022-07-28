package com.example.ruchika_apptask2

import android.os.Parcel
import android.os.Parcelable
import android.provider.ContactsContract
import com.google.gson.annotations.SerializedName

data class Valomodel (

    @SerializedName("status" ) var status : Int?            = null,
    @SerializedName("data"   ) var data   : ArrayList<ContactsContract.Data> = arrayListOf()

):Parcelable {
    constructor(parcel: Parcel):this(
        parcel.readString(),
        parcel.readString(),
    )
}
