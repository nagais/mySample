package com.example.mysample.presentation.top

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mysample.R
import com.example.mysample.databinding.TopContentBinding
import com.example.mysample.presentation.util.BindingHolder
import javax.inject.Inject

class TopContentAdapter @Inject constructor() : RecyclerView.Adapter<BindingHolder<TopContentBinding>>() {

    private val itemList: MutableList<String> = mutableListOf()

    fun add(items: List<String>) {
        val insertPosition = itemList.size
        itemList.addAll(items)
        notifyItemInserted(insertPosition)
    }

    fun clear() {
        itemList.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder<TopContentBinding> {
        return BindingHolder(parent, R.layout.top_content)
    }

    override fun onBindViewHolder(holder: BindingHolder<TopContentBinding>, position: Int) {
        holder.binding?.viewModel = TopContentViewModel(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

}
