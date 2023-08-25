package com.example.presentation.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.presentation.dashboard.model.DashboardMenuItem
import javax.inject.Inject

class DashboardViewModel @Inject constructor(
    private val provider: DashboardButtonsProvider
) : ViewModel() {

    private val _buttons = MutableLiveData<List<DashboardMenuItem>>()
    val buttons: LiveData<List<DashboardMenuItem>> by lazy {
        loadButtons()
        _buttons
    }

    private fun loadButtons() {
        _buttons.postValue(provider.getDashboardButtons())
    }
}