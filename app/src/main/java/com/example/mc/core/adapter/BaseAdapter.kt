package com.example.mc.core.adapter

import android.util.SparseArray
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

open class BaseAdapter : RecyclerView.Adapter<BaseHolder>() {

    protected val delegateAdapters: SparseArray<IDelegateAdapter> = SparseArray()

    var itemClickListener: IItemClickListener? = null

    var items: List<IItemType> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        val holder = delegateAdapters.get(viewType).onCreateViewHolder(parent)
        if (itemClickListener != null) {
            holder.setOnItemClickListener(itemClickListener as IItemClickListener)
            holder.setOnItemLongClickListener(itemClickListener as IItemClickListener)
        }
        return holder
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BaseHolder, position: Int) = holder.bind(items[position])
}