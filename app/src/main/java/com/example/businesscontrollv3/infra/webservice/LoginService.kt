package com.example.businesscontrollv3.infra.webservice

import com.example.businesscontrollv3.model.User
import com.example.businesscontrollv3.model.Login
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("/v1/login")
    suspend fun login(@Body login: Login): Response<User>
}