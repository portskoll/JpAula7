package net.mundotela.exerciciosaula7.exercicios

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.floatingactionbutton.FloatingActionButton
import net.mundotela.exerciciosaula7.R

class A07ex08 : AppCompatActivity() {

    lateinit var btnCapturar: FloatingActionButton
    lateinit var imgFoto: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a07ex08)
        title = "A07ex08"

        btnCapturar = findViewById(R.id.fabTirarFoto)
        imgFoto = findViewById(R.id.imgFoto)
    }

    val register = registerForActivityResult(
        ActivityResultContracts.TakePicturePreview()

    ){image: Bitmap? ->
        imgFoto.setImageBitmap(image)
    }

    fun capturarFoto(view: View) {
        register.launch(null)

    }
}