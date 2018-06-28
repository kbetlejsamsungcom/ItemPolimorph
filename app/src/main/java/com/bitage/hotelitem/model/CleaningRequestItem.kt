package com.bitage.hotelitem.model

import kotlinx.android.parcel.Parcelize

@Parcelize
data class CleaningRequestItem(
        val time: String?,
//@SerializedName("comment")
//@Expose
        override var comment: String?
): RequestItem(RequestType.CLEANING, comment)