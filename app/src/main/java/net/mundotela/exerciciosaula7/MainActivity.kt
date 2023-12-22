package net.mundotela.exerciciosaula7

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import net.mundotela.exerciciosaula7.exercicios.A07ex01
import net.mundotela.exerciciosaula7.exercicios.A07ex02
import net.mundotela.exerciciosaula7.exercicios.A07ex03
import net.mundotela.exerciciosaula7.exercicios.A07ex04
import net.mundotela.exerciciosaula7.exercicios.A07ex05
import net.mundotela.exerciciosaula7.exercicios.A07ex06.A07ex06
import net.mundotela.exerciciosaula7.exercicios.A07ex07.A07ex07
import net.mundotela.exerciciosaula7.exercicios.A07ex08
import net.mundotela.exerciciosaula7.exercicios.A07ex09
import net.mundotela.exerciciosaula7.exercicios.A07ex11_12
import net.mundotela.exerciciosaula7.exercicios.A08ex01
import net.mundotela.exerciciosaula7.exercicios.A08ex04.A08ex04
import net.mundotela.exerciciosaula7.exercicios.A08ex04.criarUserRandom
import net.mundotela.exerciciosaula7.exercicios.MapsActivity

class MainActivity : AppCompatActivity() {

    lateinit var exe1: Button
    lateinit var exe2: Button
    lateinit var exe3: Button
    lateinit var exe4: Button
    lateinit var exe5: Button
    lateinit var exe6: Button
    lateinit var exe7: Button
    lateinit var exe8: Button
    lateinit var exe9: Button
    lateinit var exe10: Button
    lateinit var exe11: Button
    lateinit var exe08_01: Button
    lateinit var exe08_04: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Buscando os dados do Randon User que serão usados no Aula8 ex4
        criarUserRandom()

        title = "Exercicios aula 7 e 8"

        exe1 = findViewById(R.id.btn01)
        exe2 = findViewById(R.id.btn02)
        exe3 = findViewById(R.id.btn03)
        exe4 = findViewById(R.id.btn04)
        exe5 = findViewById(R.id.btn05)
        exe6 = findViewById(R.id.btn06)
        exe7 = findViewById(R.id.btn07)
        exe8 = findViewById(R.id.btn08)
        exe9 = findViewById(R.id.btn09)
        exe10 = findViewById(R.id.btn10)
        exe11 = findViewById(R.id.btn11)
        exe08_01 = findViewById(R.id.btnA08_01)
        exe08_04 = findViewById(R.id.btnA08_04)

        val clickListener = View.OnClickListener { view ->
            when (view.id){

                R.id.btn01 -> iniciarActivity(this,A07ex01::class.java)
                R.id.btn02 -> iniciarActivity(this, A07ex02::class.java)
                R.id.btn03 -> iniciarActivity(this, A07ex03::class.java)
                R.id.btn04 -> iniciarActivity(this, A07ex04::class.java)
                R.id.btn05 -> iniciarActivity(this, A07ex05::class.java)
                R.id.btn06 -> iniciarActivity(this, A07ex06::class.java)
                R.id.btn07 -> iniciarActivity(this, A07ex07::class.java)
                R.id.btn08 -> iniciarActivity(this, A07ex08::class.java)
                R.id.btn09 -> iniciarActivity(this, A07ex09::class.java)
                R.id.btn10 -> iniciarActivity(this, MapsActivity::class.java)
                R.id.btn11 -> iniciarActivity(this, A07ex11_12::class.java)
                R.id.btnA08_01 -> iniciarActivity(this, A08ex01::class.java)
                R.id.btnA08_04 -> iniciarActivity(this, A08ex04::class.java)

            }
        }

        exe1.setOnClickListener(clickListener)
        exe2.setOnClickListener(clickListener)
        exe3.setOnClickListener(clickListener)
        exe4.setOnClickListener(clickListener)
        exe5.setOnClickListener(clickListener)
        exe6.setOnClickListener(clickListener)
        exe7.setOnClickListener(clickListener)
        exe8.setOnClickListener(clickListener)
        exe9.setOnClickListener(clickListener)
        exe10.setOnClickListener(clickListener)
        exe11.setOnClickListener(clickListener)
        exe08_01.setOnClickListener(clickListener)
        exe08_04.setOnClickListener(clickListener)

    }


    fun iniciarActivity(context: Context, activityClass: Class<*>) {
        val intent = Intent(context, activityClass)
        context.startActivity(intent)
    }




}