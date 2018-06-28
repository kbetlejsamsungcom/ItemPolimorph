package com.bitage.hotelitem.model

data class RequestItemsRequest(val type: RequestType,
                               val items: List<RequestItem>,
                               val comment: String?,
                               val deliveryDate: String)