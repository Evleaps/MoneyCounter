package com.example.mc.core.adapter

import android.view.View
import androidx.annotation.CallSuper
import androidx.recyclerview.widget.RecyclerView

abstract class BaseHolder(view: View) : RecyclerView.ViewHolder(view) {
    protected lateinit var data: IItemType

    @CallSuper
    open fun bind(item: IItemType) {
        data = item
    }

    @CallSuper
    open fun bind(item: IItemType, position: Int) {
        data = item
    }

    @CallSuper
    fun setOnItemClickListener(listener: IItemClickListener) {
        itemView.setOnClickListener { listener.onItemClicked(data) }
    }

    @CallSuper
    fun setOnItemLongClickListener(listener: IItemClickListener) {
        itemView.setOnLongClickListener {
            listener.onItemLongClicked(data)
            return@setOnLongClickListener true
        }
    }
}
