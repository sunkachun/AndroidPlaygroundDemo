package com.example.presentation.dashboard.model

import com.example.presentation.dashboard.DashboardNavigationAction

data class DashboardMenuItem(
    val title: String,
    val iconId: Int,
    val navigationAction: DashboardNavigationAction?,
)
