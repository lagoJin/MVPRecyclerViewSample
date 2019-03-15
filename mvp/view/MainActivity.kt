package com.jino.documentsearch.mvp.view

import androidx.recyclerview.widget.LinearLayoutManager
import com.jino.documentsearch.MainAdapter
import com.jino.documentsearch.R
import com.jino.documentsearch.base.BaseActivity
import com.jino.documentsearch.databinding.ActivityMainBinding
import com.jino.documentsearch.mvp.contract.MainContract
import com.jino.documentsearch.mvp.model.bean.Item
import com.jino.documentsearch.mvp.presenter.MainPresenter

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main), MainContract.View {

    private val presenter by lazy { MainPresenter() }

    override fun start() {
        presenter.attachView(this)
        mBinder.btnSearch.setOnClickListener {
            presenter.searchData(mBinder.edSearch.text.toString())
        }
    }

    override fun recyclerViewInit(items: Item) {
        mBinder.rvMain.adapter = MainAdapter(items)
        mBinder.rvMain.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }
}