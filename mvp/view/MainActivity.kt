package com.jino.documentsearch.mvp.view

import android.os.Build
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
    private var display = 10

    override fun start() {
        presenter.attachView(this)
        mBinder.btnSearch.setOnClickListener {
            display = 10
            presenter.searchData(mBinder.edSearch.text.toString(), display)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mBinder.rvMain.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
                if (!mBinder.rvMain.canScrollVertically(1)) {
                    display += 10
                    presenter.searchData(mBinder.edSearch.text.toString(), display)
                }
            }
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