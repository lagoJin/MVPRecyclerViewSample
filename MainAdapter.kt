package com.jino.documentsearch

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jino.documentsearch.databinding.ItemMainBinding
import com.jino.documentsearch.mvp.model.bean.Item

class MainAdapter(private val item: Item) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemMainBinding = DataBindingUtil.inflate(inflater, R.layout.item_main, parent, false)
        return MainViewHolder(binding)
    }

    override fun getItemCount(): Int = item.items.size

    override fun onBindViewHolder(holder: MainAdapter.MainViewHolder, position: Int) {
        holder.binding.item = item.items[position]
        holder.binding.llItem.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.items[position].link))
            holder.binding.root.context.startActivity(intent)
        }
    }

    class MainViewHolder(internal val binding: ItemMainBinding) : RecyclerView.ViewHolder(binding.root)
}