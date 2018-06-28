package com.bitage.hotelitem;

import com.bitage.hotelitem.model.CleaningRequestItem;
import com.bitage.hotelitem.model.ExtendStayRequestItem;
import com.bitage.hotelitem.model.HotelItem;
import com.bitage.hotelitem.model.LateCheckoutRequestItem;
import com.bitage.hotelitem.model.RequestItem;
import com.bitage.hotelitem.model.RequestType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkModule {

    public static RequestService getRetrofitService() {
        Gson gsonFactory = provideGsonConverterFactory();
        OkHttpClient okHttpClient = provideLoggingEnabledHttpClient(provideLoggingInterceptor());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://r1dqu9jw45.execute-api.eu-west-2.amazonaws.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gsonFactory))
                .client(okHttpClient)
                .build();
        return retrofit.create(RequestService.class);
    }

    private static HttpLoggingInterceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        return loggingInterceptor;
    }

    private static OkHttpClient provideLoggingEnabledHttpClient(HttpLoggingInterceptor loggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor (loggingInterceptor::intercept)
                .build();
    }

    private static Gson provideGsonConverterFactory() {
        RuntimeTypeAdapterFactory<RequestItem> typeFactory = RuntimeTypeAdapterFactory
                .of(RequestItem.class, "type")
                .registerSubtype(CleaningRequestItem.class, RequestType.CLEANING.name())
                .registerSubtype(LateCheckoutRequestItem.class, RequestType.LATE_CHECKOUT.name())
                .registerSubtype(HotelItem.class, RequestType.HOTEL_ITEM.name())
                .registerSubtype(ExtendStayRequestItem.class, RequestType.EXTEND_STAY.name());
        return new GsonBuilder()
                .setDateFormat(DateUtil.getISO8601_FORMAT())
                .registerTypeAdapterFactory(typeFactory)
                .create();
    }
}
