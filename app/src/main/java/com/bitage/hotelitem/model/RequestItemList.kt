package com.bitage.hotelitem.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RequestItemList(
        val items: List<RequestItem>,
        val serviceRequestId: String,
        val status: RequestItemStatus,
        val createdAt: String,
        val updatedAt: String,
        val deliveryDate: String,
// val type: RequestType,
        val messages: List<RequestMessage>) : Parcelable {

    constructor(oldItem: RequestItemList, messages: List<RequestMessage>)
            : this(
            oldItem.items,
            oldItem.serviceRequestId,
            oldItem.status,
            oldItem.createdAt,
            oldItem.createdAt,
            oldItem.deliveryDate,
// oldItem.type,
            messages
    )

    constructor(oldItem: RequestItemList, status: RequestItemStatus)
            : this(
            oldItem.items,
            oldItem.serviceRequestId,
            status,
            oldItem.createdAt,
            oldItem.createdAt,
            oldItem.deliveryDate,
// oldItem.type,
            oldItem.messages
    )

    fun totalPrice(): Int {
        return 0
    }

    fun<T:RequestItem> getItemAsType(index: Int): T {
        return items[index] as T
    }

    fun getType(): RequestType {
        return items[0].type
    }
}