package net.mundotela.exerciciosaula7.exercicios

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import net.mundotela.exerciciosaula7.R

class aula8Fim : AppCompatActivity() {

    lateinit var aFoto: ImageView
    lateinit var aNome: TextView
    lateinit var aEmail: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aula8_fim)

        aFoto = findViewById(R.id.img_fim)
        aNome= findViewById(R.id.txt_nome_fim)
        aEmail = findViewById(R.id.txt_email_final)

        val intent = intent
        val nome = intent.getStringExtra("nome")
        val email = intent.getStringExtra("email")
        val foto = intent.getStringExtra("foto")

        try {
            Glide.with(this)
                .load(foto)
                .centerCrop()
                .placeholder(R.drawable.progressbaranimation)
                .error(R.drawable.try_later)
                .into(aFoto)
        } catch (e: Exception) {
            Log.e("TAGImage", "Erro ao carregar imagem", e)
        }

        aNome.text = nome
        aEmail.text = email

        aEmail.setOnClickListener{
            val emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.data = Uri.parse("mailto:")
            emailIntent.type = "messege/rfc822"
            emailIntent.putExtra(
                Intent.EXTRA_EMAIL,
                arrayOf(email))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Aula JP teste")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "ve ai se chegou o email, vou te enviar uma grana!")
            startActivity(emailIntent)
        }


    }
}