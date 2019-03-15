package com.jino.documentsearch.api

import com.jino.documentsearch.mvp.model.bean.Item
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface APIInterface {

    @Headers("X-Naver-Client-Id: _WRT9sR_Z05lB7lfxtRI", "X-Naver-Client-Secret: Mjw5IG9a2K")
    @GET("doc.json")
    fun getDocuments(@Query("query") query: String, @Query("display") display: Int, @Query("start") start: Int): Single<Item>
}