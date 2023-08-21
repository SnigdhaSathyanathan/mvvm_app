package com.acabes.mvvmapp.viewModel
import com.acabes.mvvmapp.model.HarryPotterCharacter
import retrofit2.Response
import retrofit2.http.GET

interface APIinterface {
    @GET("/api/characters")
    suspend fun getDetails() : Response<List<HarryPotterCharacter>>
}