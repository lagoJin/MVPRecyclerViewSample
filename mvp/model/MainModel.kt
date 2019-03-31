package com.jino.documentsearch.mvp.model

import com.jino.documentsearch.api.APIClient
import com.jino.documentsearch.extension.networkCommunication
import com.jino.documentsearch.mvp.model.bean.Item
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainModel {

    fun searchItems(query: String, display: Int): Single<Item> {
        return APIClient.instance.getDocuments(query, display, 1).networkCommunication()
    }
}