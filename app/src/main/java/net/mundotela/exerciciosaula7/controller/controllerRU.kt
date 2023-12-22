package net.mundotela.exerciciosaula7.controller

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

data class UserResponseRU(val results: List<User>)

// models
data class User(val name: Name, val email: String, val phone: String, val picture: Picture)
data class Picture(val large: String)
data class Name(val title: String, val first: String, val last: String)

interface UserServiceRU {
    @GET("api/?results=100")

    fun getUserRU(): Call<UserResponseRU>
}



val serviceRU = Retrofit.Builder()
    .baseUrl("https://randomuser.me/")
    .addConverterFactory(MoshiConverterFactory.create())
    .build()
    .create(UserServiceRU::class.java)

