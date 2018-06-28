package com.bitage.hotelitem.model

import com.bitage.hotelitem.R

enum class RequestType(val resId: Int) {
    HOTEL_ITEM(R.string.myrequest_item_request_type),
    CLEANING(R.string.myrequest_housekeeping_type),
    LATE_CHECKOUT(R.string.myrequest_late_check_out_type),
    EXTEND_STAY(R.string.myrequest_extend_stay_type);

}