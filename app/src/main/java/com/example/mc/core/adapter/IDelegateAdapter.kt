package com.example.mc.core.adapter

import android.view.ViewGroup

interface IDelegateAdapter {
    fun onCreateViewHolder(parent: ViewGroup): BaseHolder
}