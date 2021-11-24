package com.rememberchina

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rememberchina.list_wefw.ChinaEventApiStatus
import com.rememberchina.network.ChinaEvent
import com.rememberchina.e_RemoteDataSource.network.ListFragmentAdapter
import com.rememberchina.fragment_list.ChinaEventApiStatus


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<ChinaEvent>?) {
    val adapter = recyclerView.adapter as ListFragmentAdapter
    adapter.submitList(data)
}

@BindingAdapter("chinaEventApiStatus")
fun bindStatus(statusImageView: ImageView, status: ChinaEventApiStatus?) {
    when (status) {
        ChinaEventApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        ChinaEventApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.connection_error)
        }
        ChinaEventApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}
