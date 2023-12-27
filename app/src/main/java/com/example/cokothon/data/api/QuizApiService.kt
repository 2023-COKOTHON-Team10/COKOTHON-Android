package com.example.cokothon.data.api

import com.example.cokothon.data.dto.BaseResponse
import com.example.cokothon.data.dto.request.RequestAnswerDto
import com.example.cokothon.data.dto.request.RequestQuizDto
import com.example.cokothon.data.dto.request.RequestUserDto
import com.example.cokothon.presentation.UserData
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface QuizApiService {

    @POST("api/user")
    fun postUser(
        @Body requestUser: RequestUserDto
    ): Call<Unit>

//    @POST("api/answer")
//    suspend fun postAnswer(
//        @Body requestAnswer: RequestAnswerDto
//    ): BaseResponse<Unit>
//
//    @POST("api/quiz")
//    suspend fun postQuiz(
//        @Body requestQuiz: RequestQuizDto
//    ): BaseResponse<Unit>
}