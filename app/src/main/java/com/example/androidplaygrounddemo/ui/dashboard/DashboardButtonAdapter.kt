package com.example.androidplaygrounddemo.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidplaygrounddemo.databinding.ItemDashboardButtonBinding
import com.example.androidplaygrounddemo.ui.dashboard.DashboardButtonAdapter.ViewHolder
import com.example.androidplaygrounddemo.ui.generic.adapter.SimpleItemDiff
import com.example.presentation.dashboard.model.DashboardMenuItem

class DashboardButtonAdapter constructor(
    private val onButtonClicked: (DashboardMenuItem) -> Unit,
) : ListAdapter<DashboardMenuItem, ViewHolder>(SimpleItemDiff { title } ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDashboardButtonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(ui = binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val ui: ItemDashboardButtonBinding) : RecyclerView.ViewHolder(ui.root) {

        init {
            ui.dashboardButtonContainer.setOnClickListener {
                onButtonClicked(currentList[absoluteAdapterPosition])
            }
        }

        fun bind(dashboardMenuItem: DashboardMenuItem) {
            ui.btnImage.setImageResource(dashboardMenuItem.iconId)
            ui.btnTitle.text = dashboardMenuItem.title
        }
    }
}