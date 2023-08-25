package com.example.presentation.dashboard

import com.example.presentation.dashboard.model.DashboardMenuItem

interface DashboardButtonsProvider {

    fun getDashboardButtons(): List<DashboardMenuItem>
}