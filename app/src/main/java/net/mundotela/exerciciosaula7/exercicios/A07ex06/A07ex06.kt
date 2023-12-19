package net.mundotela.exerciciosaula7.exercicios.A07ex06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.mundotela.exerciciosaula7.R

class A07ex06 : AppCompatActivity() {

    lateinit var r: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a07ex06)
        title = "A07ex06"

        r = findViewById(R.id.rv)
        r.layoutManager = LinearLayoutManager(this)
        var arr = Array<String>(100) {"$it"}
        var adpter = CustomAdapter(arr)
        r.adapter = adpter
    }
}