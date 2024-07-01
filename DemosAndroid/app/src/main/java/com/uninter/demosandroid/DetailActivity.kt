package com.uninter.demosandroid

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {

    var tag =  "CicloVida"
    var className = "${javaClass.name.substring(javaClass.name.lastIndexOf(".") + 1)}"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        Log.d(tag, "$className - onCreate")

        var pessoa = intent.extras?.get("fagner") as Pessoa

        findViewById<TextView>(R.id.txtDetail).text = pessoa?.nome
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "$className - onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag, "$className - onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "$className - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "$className - onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "$className - onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "$className - onDestroy")
    }
}