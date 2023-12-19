package net.mundotela.exerciciosaula7.exercicios

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import com.google.android.material.floatingactionbutton.FloatingActionButton
import net.mundotela.exerciciosaula7.R

class A07ex03 : AppCompatActivity() {

    lateinit var fb1: FloatingActionButton
    lateinit var fb2: FloatingActionButton
    lateinit var fb3: FloatingActionButton
    lateinit var fb4: FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a07ex03)
        title = "A07ex03"

        fb1 = findViewById(R.id.floatingActionButtonWeb)
        fb2 = findViewById(R.id.floatingActionButtonTel)
        fb3 = findViewById(R.id.floatingActionButtonSMS)
        fb4 = findViewById(R.id.floatingActionButtonEmail)
        val url: EditText = findViewById(R.id.edtWeb)




        val clickListener = View.OnClickListener { view ->
            when (view.id){
                R.id.floatingActionButtonWeb -> {
                    val site = url.text.toString()
                    Log.d("site : ", site)

                    val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=$site"))
                    startActivity(webIntent)

                }
                R.id.floatingActionButtonTel -> {
                    val telIntent = Intent(Intent.ACTION_VIEW, Uri.parse("tel:1798410282"))
                    startActivity(telIntent)
                }
                R.id.floatingActionButtonSMS -> {
                    val smsIntent = Intent(Intent.ACTION_VIEW, Uri.parse("sms:1798410282"))
                    startActivity(smsIntent)
                }
                R.id.floatingActionButtonEmail -> {
                    val emailIntent = Intent(Intent.ACTION_SEND)
                    emailIntent.data = Uri.parse("mailto:")
                    emailIntent.type = "messege/rfc822"
                    emailIntent.putExtra(Intent.EXTRA_EMAIL,
                        arrayOf("portskoll@hotmail.com", "pix@texugoimports.com.br"))
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Aula JP teste")
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "ve ai se chegou o email, vou te enviar uma grana!")
                    startActivity(emailIntent)
                }
            }
        }

        fb1.setOnClickListener(clickListener)
        fb2.setOnClickListener(clickListener)
        fb3.setOnClickListener(clickListener)
        fb4.setOnClickListener(clickListener)
    }
}