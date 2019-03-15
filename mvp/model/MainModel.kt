package com.jino.documentsearch.mvp.model

import com.jino.documentsearch.api.APIClient
import com.jino.documentsearch.mvp.model.bean.Item
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainModel {

    fun searchItems(query: String): Single<Item> {
        return APIClient.instance.getDocuments(query, 10, 1)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}