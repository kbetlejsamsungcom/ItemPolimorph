package com.bitage.hotelitem

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bitage.hotelitem.model.*
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder
import com.google.gson.Gson
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showRequest.setOnClickListener {
            val service = NetworkModule.getRetrofitService()
            val result = service.getMyRequestList("PENDING")
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe ({
                        list.adapter = RequestAdapter(it)
                    }) {
                        Log.e("KGB", "error:", it)
                    }
        }

        postRequest.setOnClickListener {
            val items = getTestItems()
            val service = NetworkModule.getRetrofitService()
            val result = service.postItemRequest(items)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe ({
                        Log.e("kgb", "ok")
                    }) {
                        Log.e("KGB", "error:", it)
                    }
        }

    }

    internal fun getTestItems(): RequestItemsRequest {
        return RequestItemsRequest(
                RequestType.HOTEL_ITEM,
                makeHotelItems(),
                null,
                getDate()
        )
    }

    private fun makeHotelItems(): List<RequestItem> {
        val result = ArrayList<RequestItem>()
        result.add(HotelItem("Water", 1))
        result.add(HotelItem("test2", 1))
        result.add(HotelItem("test3", 1))
        return result
    }

    private fun getDate(): String {
        return "2018-05-07T12:00:00Z"
    }
}
