package com.example.presentation.dashboard

sealed interface DashboardNavigationAction {

    object OpenFlower: DashboardNavigationAction
    object OpenWeather: DashboardNavigationAction
}