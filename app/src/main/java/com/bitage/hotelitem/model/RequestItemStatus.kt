package com.bitage.hotelitem.model

import com.bitage.hotelitem.R

enum class RequestItemStatus(val resId: Int) {
    PENDING(R.string.pending),
    CANCELLED(R.string.canceled),
    COMPLETED(R.string.completed)
}