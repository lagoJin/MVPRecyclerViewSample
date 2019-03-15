package com.jino.documentsearch.api

import com.jino.documentsearch.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {

    companion object {
        private lateinit var clientId: String
        private lateinit var clientSecret: String
        internal lateinit var instance: APIInterface

        fun init(clientId: String, clientSecret: String) {
            Companion.clientId = clientId
            Companion.clientSecret = clientSecret
            val interceptor = HttpLoggingInterceptor()
            if (!BuildConfig.DEBUG) interceptor.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient().newBuilder().addInterceptor(interceptor).build()

            instance = Retrofit.Builder().apply {
                baseUrl("https://openapi.naver.com/v1/search/")
                addConverterFactory(GsonConverterFactory.create())
                addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                client(client)
            }.build().create(APIInterface::class.java)
        }
    }
}