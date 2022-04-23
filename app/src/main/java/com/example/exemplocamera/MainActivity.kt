package com.example.exemplocamera

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    lateinit var btnCapturar: Button
    lateinit var imgFoto: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCapturar = findViewById(R.id.btnCapturar)
        imgFoto = findViewById(R.id.imgFoto)
    }

    // objeto de registro do evento de tirar foto
    val register = registerForActivityResult(
        ActivityResultContracts.TakePicturePreview()
    ) { image: Bitmap? ->
        imgFoto.setImageBitmap(image)
    }

    // evento (colocar no 'onClick' do botão)
    fun capturarFoto(view: View) {
        register.launch(null) // disparar o evento registrado
    }
}