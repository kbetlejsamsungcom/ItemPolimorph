package com.bitage.hotelitem.model

import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize

@Parcelize
class HotelItem(
        val name: String,
        var count: Int,
        override var comment: String? = null
): RequestItem(RequestType.HOTEL_ITEM, comment) {
    @IgnoredOnParcel
    var price: Float = 0F
    @IgnoredOnParcel
    var selected: Boolean = false

    fun getIcon(): String? {
        return ""
    }
}