package com.rememberchina.network

import android.R
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rememberchina.databinding.ListViewItemBinding

class ListFragmentAdapter : ListAdapter<ChinaEvent, ListFragmentAdapter.ChinaEventViewHolder>(
    DiffCallback
) {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ChinaEventViewHolder {

        return ChinaEventViewHolder(
            ListViewItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: ChinaEventViewHolder, position: Int) {
        val chinaEvent = getItem(position)
        holder.bind(chinaEvent)

    }

    class ChinaEventViewHolder(private var binding: ListViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(chinaEvent: ChinaEvent) {
            binding.chinaEvents = chinaEvent
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<ChinaEvent>() {

        override fun areItemsTheSame(oldItem: ChinaEvent, newItem: ChinaEvent): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: ChinaEvent, newItem: ChinaEvent): Boolean {
            return oldItem.id == newItem.id
        }
    }
}

