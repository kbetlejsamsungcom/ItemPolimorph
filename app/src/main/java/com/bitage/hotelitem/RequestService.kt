package com.bitage.hotelitem

import com.bitage.hotelitem.model.MyRequestList
import com.bitage.hotelitem.model.RequestItemList
import com.bitage.hotelitem.model.RequestItemsRequest
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface RequestService {
    @POST("api/guests/me/requests")
    fun postItemRequest(@Body responseRequest: RequestItemsRequest): Observable<RequestItemList>

    @GET("api/guests/me/requests")
    fun getMyRequestList(@Query("status") status: String): Observable<MyRequestList>
}