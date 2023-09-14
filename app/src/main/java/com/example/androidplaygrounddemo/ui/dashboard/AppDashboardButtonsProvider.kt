package com.example.androidplaygrounddemo.ui.dashboard

import android.content.Context
import com.example.androidplaygrounddemo.R
import com.example.presentation.dashboard.DashboardButtonsProvider
import com.example.presentation.dashboard.DashboardNavigationAction
import com.example.presentation.dashboard.model.DashboardMenuItem
import javax.inject.Inject

class AppDashboardButtonsProvider @Inject constructor(
    private val context: Context
): DashboardButtonsProvider {

    override fun getDashboardButtons(): List<DashboardMenuItem> {
        return listOf(
            DashboardMenuItem(
                "Weather",
                R.drawable.ic_dashboard_button_sunny,
                DashboardNavigationAction.OpenWeather
            ),
            DashboardMenuItem(
                "Flower",
                R.drawable.ic_dashboard_button_flower,
                DashboardNavigationAction.OpenFlower
            ),
            DashboardMenuItem(
                "To Do List",
                R.drawable.ic_dashboard_to_do,
                DashboardNavigationAction.OpenToDoList
            )
        )
    }
}