package com.petitoff.retrofit_tutorial.routing.services

import com.petitoff.retrofit_tutorial.routing.models.Route
import retrofit2.http.GET

interface RouteService {
    @GET("pedestrian-route")
    suspend fun getPedestrianRoute(): Route
}