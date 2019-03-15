package com.jino.documentsearch.mvp.model.bean

data class Item(
    val display: Int,
    val items: List<ItemX>,
    val lastBuildDate: String,
    val start: Int,
    val total: Int
)