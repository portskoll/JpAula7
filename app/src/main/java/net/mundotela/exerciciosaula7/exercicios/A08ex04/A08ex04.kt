package net.mundotela.exerciciosaula7.exercicios.A08ex04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.mundotela.exerciciosaula7.R

class A08ex04 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a08ex04)
        title = "A08ex4"


        var r = findViewById<RecyclerView>(R.id.rv_user_random)
        r.layoutManager = LinearLayoutManager(this)


        val arr = ListUser.users

        var adpter = CustonAdpeter3(this, arr)
        r.adapter = adpter

    }


}