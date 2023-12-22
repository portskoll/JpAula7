package net.mundotela.exerciciosaula7.exercicios.A08ex04

import android.util.Log
import net.mundotela.exerciciosaula7.controller.UserResponseRU
import net.mundotela.exerciciosaula7.controller.serviceRU
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserRandom(val foto: String = "", val nome: String = "", val email: String = "") {

}
object ListUser{
    val users = ArrayList<UserRandom>()

}
fun criarUserRandom(): Unit{



    serviceRU.getUserRU().enqueue(object : Callback<UserResponseRU>{
        override fun onResponse(call: Call<UserResponseRU>, response: Response<UserResponseRU>) {
            val dadosrecebidos = response.body()!!.results
            ListUser.users.clear()
            for (u in dadosrecebidos){
                ListUser.users.add(UserRandom(u.picture.large,"${u.name.first} ${u.name.last}", u.email))
            }



        }

        override fun onFailure(call: Call<UserResponseRU>, t: Throwable) {
            TODO("Not yet implemented")
        }
    })




}