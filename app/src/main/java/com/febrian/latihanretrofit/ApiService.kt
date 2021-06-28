package com.febrian.latihanretrofit

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/posts")
    fun getData() : Call<ArrayList<DataResponse>>
}