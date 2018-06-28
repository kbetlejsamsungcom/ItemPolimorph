package com.bitage.hotelitem.model

/**
 * @author Krzysztof Betlej <k.betlej@samsung.com>.
 * @date 5/16/18
 * @copyright Copyright (c) 2016 by Samsung Electronics Polska Sp. z o. o.
 */

data class MyRequestList(val content: MutableList<RequestItemList>) {

    fun items(): List<RequestItemList> {
        return content
    }

    fun size(): Int {
        return content.size
    }

    fun get(index:Int): RequestItemList {
        return content.get(index)
    }
}