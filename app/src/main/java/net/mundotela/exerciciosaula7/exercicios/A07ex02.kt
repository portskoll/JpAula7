package net.mundotela.exerciciosaula7.exercicios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import net.mundotela.exerciciosaula7.R

class A07ex02 : AppCompatActivity() {
    lateinit var texto: TextView
    lateinit var tela: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a07ex02)

        title = "A07ex02"

        texto = findViewById(R.id.txt_ex2_texto)
        tela = findViewById(R.id.TodaTela)

        tela.setOnClickListener{view ->

            var snack = Snackbar.make(view, texto.text, Snackbar.LENGTH_INDEFINITE)
            snack.setAction("Fechar", {snack.dismiss()})
            snack.show()

        }
    }
}