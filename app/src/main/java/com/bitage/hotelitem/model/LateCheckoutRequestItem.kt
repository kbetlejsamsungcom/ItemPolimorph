package com.bitage.hotelitem.model

import kotlinx.android.parcel.Parcelize

@Parcelize
data class LateCheckoutRequestItem(
        val checkoutTime: String,
        override var comment: String? = null
) : RequestItem(RequestType.LATE_CHECKOUT, comment)