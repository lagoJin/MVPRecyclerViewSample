package com.jino.documentsearch.mvp.presenter

import com.jino.documentsearch.base.BasePresenter
import com.jino.documentsearch.mvp.contract.MainContract
import com.jino.documentsearch.mvp.model.MainModel
import com.jino.documentsearch.utils.Logger

class MainPresenter : BasePresenter<MainContract.View>(), MainContract.Presenter {

    private val mainModel: MainModel by lazy { MainModel() }

    override fun searchData(query: String) {
        val disposable = mainModel.searchItems(query)
            .subscribe(
                { result ->
                    mRootView?.recyclerViewInit(result)
                },
                { Logger.e(it.localizedMessage) }
            )
        addSubScription(disposable)
    }
}