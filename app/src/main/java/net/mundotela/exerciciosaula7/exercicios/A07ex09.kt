package net.mundotela.exerciciosaula7.exercicios

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.mlkit.vision.barcode.BarcodeScanner
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.common.InputImage
import net.mundotela.exerciciosaula7.R

class A07ex09 : AppCompatActivity() {

    lateinit var btnCapturar: FloatingActionButton
    lateinit var imgFoto: ImageView
    lateinit var resultadoQR: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a07ex09)

        btnCapturar  = findViewById(R.id.fabTirarFotoQR)
        imgFoto  = findViewById(R.id.imgFotoQR)
        resultadoQR = findViewById(R.id.txtResultadoQR)


    }

    private val register = registerForActivityResult(
        ActivityResultContracts.TakePicturePreview()

    ){ image: Bitmap? ->
        imgFoto.setImageBitmap(image)

        val scanner = BarcodeScanning.getClient()
        val bitmap = InputImage.fromBitmap(image!!, 0)

        val result = scanner.process(bitmap)
            .addOnSuccessListener { barcodes ->
                for(barcode in barcodes){
                    val valueType = barcode.valueType
                    when(valueType){
                        Barcode.TYPE_URL -> {
                            val url = barcode.url!!.url
                            resultadoQR.text = url.toString()
                        }
                        Barcode.TYPE_TEXT -> {
                            val text = barcode.rawValue
                            resultadoQR.text = text
                        }
                        Barcode.TYPE_PRODUCT -> {
                            val text = barcode.rawValue
                            resultadoQR.text = text
                        }
                    }
                }
            }.addOnFailureListener{
                Log.e("====>", it.printStackTrace().toString())
            }

    }

    fun capturarFotoQR(view: View) {
        register.launch(null)

    }
}