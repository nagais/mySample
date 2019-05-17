package com.example.mysample.presentation.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BindingHolder<T : ViewDataBinding>(parent: ViewGroup, resId: Int) :
    RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(resId, parent)) {

    val binding: T?

    init {
        binding = DataBindingUtil.bind(itemView)
    }
}



