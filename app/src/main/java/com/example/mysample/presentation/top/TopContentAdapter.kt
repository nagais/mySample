package com.example.mysample.presentation.top

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mysample.R
import com.example.mysample.databinding.TopContentBinding
import com.example.mysample.presentation.util.BindingHolder
import javax.inject.Inject

class TopContentAdapter @Inject constructor() : RecyclerView.Adapter<BindingHolder<TopContentBinding>>() {

    val itemList: MutableList<String> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder<TopContentBinding> {
        return BindingHolder(parent, R.layout.top_content)
    }

    override fun onBindViewHolder(holder: BindingHolder<TopContentBinding>, position: Int) {
        // TODO
    }

    override fun getItemCount(): Int = itemList.size

}
