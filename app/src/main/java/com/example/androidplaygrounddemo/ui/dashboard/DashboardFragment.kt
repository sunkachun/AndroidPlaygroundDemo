package com.example.androidplaygrounddemo.ui.dashboard

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.androidplaygrounddemo.R
import com.example.androidplaygrounddemo.databinding.FragmentDashboardBinding
import com.example.presentation.dashboard.DashboardNavigationAction
import com.example.presentation.dashboard.DashboardViewModel
import com.example.presentation.dashboard.model.DashboardMenuItem
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class DashboardFragment : DaggerFragment(R.layout.fragment_dashboard) {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val ui by viewBinding<FragmentDashboardBinding>()

    private val viewModel: DashboardViewModel by viewModels { factory }

    private val buttonAdapter = DashboardButtonAdapter(::handleNavigation)

    override fun onStart() {
        super.onStart()
        ui.dashboardButtons.adapter = buttonAdapter
        observeViewModel()
    }
    private fun observeViewModel() {
        viewModel.buttons.observe(viewLifecycleOwner, ::initButton)
    }
    private fun initButton(buttons: List<DashboardMenuItem>) {
        buttonAdapter.submitList(buttons)
    }

    private fun handleNavigation(dashboardMenuItem: DashboardMenuItem) {
        Log.d("chris", "dashboardMenuItem: ${dashboardMenuItem}")
        val action = when (dashboardMenuItem.navigationAction) {
            DashboardNavigationAction.OpenWeather -> DashboardFragmentDirections.actionDashboardToWeatherFragment()
            else -> DashboardFragmentDirections.actionDashboardToWeatherFragment()
        }
        findNavController().navigate(action)
    }
}