package net.mundotela.exerciciosaula7.exercicios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide
import net.mundotela.exerciciosaula7.MinhasImages
import net.mundotela.exerciciosaula7.R



class A07ex05 : AppCompatActivity() {

    lateinit var img: ImageView
    lateinit var mudarImagem: Button
    var nImage: Int = 0
    var urlImg: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a07ex05)
        title = "A07ex05"


        img = findViewById(R.id.img_aula5)
        mudarImagem = findViewById(R.id.btnMudaImagem)

        mudarImagem.setOnClickListener(){
            if(nImage > 4 ) nImage = 0
            nImage++
            urlImg = MinhasImages(nImage).getUrl()

            try {
                Glide.with(this)
                    .load(urlImg)
                    .centerCrop()
                    .placeholder(R.drawable.progressbaranimation)
                    .error(R.drawable.try_later)
                    .into(img)
            } catch (e: Exception) {
                Log.e("TAGImage", "Erro ao carregar imagem", e)
            }

        }




    }
}