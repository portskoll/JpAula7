package net.mundotela.exerciciosaula7.exercicios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import net.mundotela.exerciciosaula7.R

class A07ex01 : AppCompatActivity() {

    lateinit var texto: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a07ex01)
        title = "A07ex01"

        texto = findViewById(R.id.txtResultado)

        texto.setOnClickListener{view ->

                var snack = Snackbar.make(view, texto.text, Snackbar.LENGTH_INDEFINITE)
                snack.setAction("Fechar", {snack.dismiss()})
                snack.show()

        }
    }
}