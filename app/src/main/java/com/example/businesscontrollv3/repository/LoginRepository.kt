package com.example.businesscontrollv3.repository

import com.example.businesscontrollv3.infra.webservice.LoginAPI
import com.example.businesscontrollv3.infra.webservice.LoginAPI.loginService
import com.example.businesscontrollv3.infra.webservice.LoginHttp
import com.example.businesscontrollv3.model.Result
import com.example.businesscontrollv3.model.User
import com.example.businesscontrollv3.model.Usuario
import java.lang.Exception


class LoginRepository {

    val loginString = LoginAPI.loginService

    suspend fun  loginOld(email: String, password: String): Result<User>{
        return LoginHttp.doLogin(Usuario(email, password))
    }

    suspend fun login(email: String,password: String): Result<User>{
        val response = loginService.login(Usuario(email, password))
        return if (response.isSuccessful){
            response.body()?.let { Result.Success(it) }?: Result.Error(Exception("Retorno vazio"))
        }else{
            val responseBodyError = response.errorBody()
            Result.Error(Exception(responseBodyError?.string()))
        }
    }

//    private suspend fun simulacaoDeChamadaParaService(email: String, password: String): Result<Usuario> {
//        delay(2000)
//
//          return when(verifyPassword(email, password)) {
//            true -> Result.Success(Usuario(email, password))
//            false -> Result.Error(Exception("Email ou senha Invalidos"))
//        }
//
//    }
//
//
//    private fun verifyPassword(email: String, password: String): Boolean {
//        val fakeUser = Usuario("admin@admin.com", "admin")
//
//        return email == fakeUser.email && password == fakeUser.password
//    }

}