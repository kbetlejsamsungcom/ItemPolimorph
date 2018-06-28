package com.bitage.hotelitem.model

import android.os.Parcelable

abstract class RequestItem(
//@SerializedName("type")
        @Transient
        val type: RequestType,
        @Transient
        open var comment: String? = null
): Parcelable