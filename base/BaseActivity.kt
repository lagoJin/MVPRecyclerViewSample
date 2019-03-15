package com.jino.documentsearch.base

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<B : ViewDataBinding>(private val layoutId: Int) : AppCompatActivity() {

    protected lateinit var mBinder: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinder = DataBindingUtil.setContentView(this, layoutId)
        start()
    }

    abstract fun start()

}