package com.uninter.demosandroid

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnIntent).setOnClickListener{

            //Visualizaçao de conteudo - Abrir o site
//            var myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
//            startActivity(myIntent)

            //Visualizaçao de conteudo - Abrir uma localização
            var myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("geo://@-25.4282293,-49.2782484,17z"))
            startActivity(myIntent)


            //Realizar uma ligação
//            var myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("tel://41999999999"))
//            startActivity(myIntent)


            //Tirar uma foto
//            var myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
//            startActivity(myIntent)

        }
    }
}