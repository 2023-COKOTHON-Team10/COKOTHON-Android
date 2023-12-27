package com.example.cokothon.data.api

import com.example.cokothon.data.dto.request.RequestUniqueNumDto
import com.example.cokothon.data.dto.request.RequestUserDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface QuizApiService {

    @POST("api/user")
    fun postUser(
        @Body requestUser: RequestUserDto
    ): Call<Long>

    @GET("api/getUniqueNum")
    fun getUniqueNum(
        @Body requestUniqueNum: RequestUniqueNumDto
    ): Call<String>
}