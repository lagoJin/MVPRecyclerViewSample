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

    init{
        presenter.attachView(this)
    }

    override fun start() {

        dataBinding.btnSearch.setOnClickListener {
            display = 10
            presenter.searchData(dataBinding.edSearch.text.toString(), display)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            dataBinding.rvMain.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
                if (!dataBinding.rvMain.canScrollVertically(1)) {
                    display += 10
                    presenter.searchData(dataBinding.edSearch.text.toString(), display)
                }
            }
        }

    }

    override fun recyclerViewInit(items: Item) {
        dataBinding.rvMain.adapter = MainAdapter(items)
        dataBinding.rvMain.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }
}