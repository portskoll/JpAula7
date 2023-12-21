package net.mundotela.exerciciosaula7.controller

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

data class UserResponseLista(val login: String, val id: Int, val avatar_url: String)

interface UserServiceLista {
    @GET("users")
    fun getUserLista(): Call<List<UserResponseLista>>
}

val serviceLista = Retrofit.Builder()
    .baseUrl("https://api.github.com/")
    .addConverterFactory(MoshiConverterFactory.create())
    .build()
    .create(UserServiceLista::class.java)

