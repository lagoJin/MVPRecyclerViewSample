package com.jino.documentsearch.mvp.contract

import com.jino.documentsearch.base.IBaseView
import com.jino.documentsearch.base.IPresenter
import com.jino.documentsearch.mvp.model.bean.Item

interface MainContract {

    interface View : IBaseView {
        fun recyclerViewInit(items: Item)
    }

    interface Presenter : IPresenter<View> {
        fun searchData(query: String,display: Int)
    }

}