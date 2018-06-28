package com.bitage.hotelitem.model

import kotlinx.android.parcel.Parcelize

@Parcelize
data class ExtendStayRequestItem(
        val date: String,
        override var comment: String? = null
): RequestItem(RequestType.EXTEND_STAY, comment)