package com.example.enparadigmassignment.ui.weather

import androidx.recyclerview.widget.DiffUtil
import com.example.enparadigmassignment.R
import com.example.enparadigmassignment.data.model.DailyItem
import com.example.enparadigmassignment.ui.base.adapter.BaseListAdapter
import com.example.enparadigmassignment.ui.base.adapter.BaseViewHolder

class MainActivityAdapter(val listener: MainNavigator) : BaseListAdapter<DailyItem>(AvatarDiffCallback) {

    override fun getLayoutIdForPosition(position: Int): Int = R.layout.item_weather

    override fun getCallbackForPosition(position: Int): Any = listener

    override fun onBindViewHolder(holder: BaseViewHolder<DailyItem>, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.itemView.setOnClickListener {
            getItem(position)?.apply {
                listener.onClickItem(this)
            }
        }
    }
    companion object {
        val AvatarDiffCallback = object : DiffUtil.ItemCallback<DailyItem>() {
            override fun areItemsTheSame(oldItem: DailyItem, newItem: DailyItem): Boolean {
                return oldItem.dt== newItem.dt
            }

            override fun areContentsTheSame(oldItem: DailyItem, newItem: DailyItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}