package com.example.businesscontrollv3.infra.webservice
import com.example.businesscontrollv3.model.Result
import com.example.businesscontrollv3.model.User
import com.example.businesscontrollv3.model.Login
import com.google.gson.Gson
import java.io.InputStreamReader
import java.io.Reader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

object LoginHttp {

    private const val loginURL = "https://business-controll-backend.herokuapp.com/v1/login"

    private val gson: Gson = Gson()

    suspend fun doLogin(login: Login): Result<User>{
        val url = URL(loginURL)

        (url.openConnection() as HttpURLConnection).run {
            requestMethod = "POST"
            setRequestProperty("Content-Type","application/json; utf-8")
            setRequestProperty("Accept", "application/json")
            doOutput = true

            val reader: Reader = InputStreamReader(inputStream,"utf-8")
            val usuario = gson.fromJson(reader, User::class.java)

            return Result.Success(usuario)
        }
        return Result.Error(Exception("Não foi possívvel iniciar uma conexão com a internet"))
    }
}