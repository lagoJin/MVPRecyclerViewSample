package com.jino.documentsearch.base

import android.app.Activity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jino.documentsearch.utils.Logger

abstract class BaseActivity<B : ViewDataBinding>(private val layoutId: Int) : AppCompatActivity() {

    companion object {
        private val arrayList = ArrayList<Activity>()
    }

    protected lateinit var mBinder: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinder = DataBindingUtil.setContentView(this, layoutId)
        Logger.d("onCreate ${this.javaClass.simpleName}")
        arrayList.add(this)
        start()
    }

    abstract fun start()

    fun clearActivity() {
        arrayList.clear()
    }

    override fun onDestroy() {
        arrayList.remove(this)
        Logger.d("onDestroy ${this.javaClass.simpleName}")
        super.onDestroy()
    }

}