package com.vedantbhamare.catappgdp

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class CatModel (
    @SerializedName("id"                 ) var id               : String? = null,
    @SerializedName("name"               ) var name             : String? = null,
    @SerializedName("origin"             ) var origin           : String? = null,
    @SerializedName("description"        ) var description      : String? = null,
    @SerializedName("life_span"          ) var lifeSpan         : String? = null,
    @SerializedName("temperament"        ) var temperament      : String? = null,
    @SerializedName("image"              ) var image            : Image?  = Image()
): Parcelable {
    constructor(parcel: Parcel) : this(
        id = parcel.readString(),
        name = parcel.readString(),
        origin = parcel.readString(),
        description = parcel.readString(),
        lifeSpan = parcel.readString(),
        temperament = parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(origin)
        parcel.writeString(description)
        parcel.writeString(lifeSpan)
        parcel.writeString(temperament)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CatModel> {
        override fun createFromParcel(parcel: Parcel): CatModel {
            return CatModel(parcel)
        }

        override fun newArray(size: Int): Array<CatModel?> {
            return arrayOfNulls(size)
        }
    }
}

data class Image (
    @SerializedName("id"     ) var id     : String? = null,
    @SerializedName("width"  ) var width  : Int?    = null,
    @SerializedName("height" ) var height : Int?    = null,
    @SerializedName("url"    ) var url    : String? = null
)
