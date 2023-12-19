package net.mundotela.exerciciosaula7.exercicios.A07ex07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.mundotela.exerciciosaula7.R

class A07ex07 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a07ex07)
        title = "A07ex07"

        var r = findViewById<RecyclerView>(R.id.r_ex7)
        r.layoutManager = LinearLayoutManager(this)

        val arr = criarProdutos()
        var adpter = CustomAdpter2(this,arr)
        r.adapter = adpter

    }
}


