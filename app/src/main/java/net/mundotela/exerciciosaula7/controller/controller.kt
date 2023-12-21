package net.mundotela.exerciciosaula7.controller

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

data class UserResponse(val login: String, val name: String)

interface UserService {
    @GET("users/portskoll")

    fun getUser(): Call<UserResponse>
}



val service = Retrofit.Builder()
    .baseUrl("https://api.github.com/")
    .addConverterFactory(MoshiConverterFactory.create())
    .build()
    .create(UserService::class.java)

