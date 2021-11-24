package com.rememberchina

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rememberchina.network.ChinaEvent
import com.rememberchina.network.ListFragmentAdapter


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<ChinaEvent>?) {
    val adapter = recyclerView.adapter as ListFragmentAdapter
    adapter.submitList(data)
}