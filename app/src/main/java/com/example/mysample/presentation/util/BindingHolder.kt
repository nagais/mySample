package com.example.mysample.presentation.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BindingHolder<T : ViewDataBinding>(parent: ViewGroup, @LayoutRes resId: Int) :
    RecyclerView.ViewHolder(
        DataBindingUtil.inflate<T>(
            LayoutInflater.from(parent.context),
            resId,
            parent,
            false
        ).root
    ) {

    val binding: T? = DataBindingUtil.bind(itemView)

}



