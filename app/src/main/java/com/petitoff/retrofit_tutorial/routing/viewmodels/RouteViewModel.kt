package com.petitoff.retrofit_tutorial.routing.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.petitoff.retrofit_tutorial.routing.models.Route
import com.petitoff.retrofit_tutorial.routing.services.RouteService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RouteViewModel : ViewModel() {
    val _route: MutableLiveData<Route> = MutableLiveData<Route>()
    val route: LiveData<Route> = _route

    init {
        fetchRoute()
    }

    private fun fetchRoute() {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(RouteService::class.java)
        viewModelScope.launch {
            try {
                val route = apiService.getPedestrianRoute()
                _route.postValue(route)
            } catch (e: Exception) {
                Log.e("RouteViewModel", "Error fetching route", e)
            }
        }
    }
}