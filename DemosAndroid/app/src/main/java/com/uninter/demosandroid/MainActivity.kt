package com.uninter.demosandroid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var count = 0
    var tag =  "CicloVida"
    var className = "${javaClass.name.substring(javaClass.name.lastIndexOf(".") + 1)}"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(tag,"$className - onCreate")

        if(savedInstanceState != null)
        {
            count = savedInstanceState.getInt("ChaveDoContador")
            Log.d(tag,"$className - recuperar estado")

        }
        Log.d(tag,"$count")

        findViewById<Button>(R.id.button).setOnClickListener{

            var intent = Intent(this,DetailActivity::class.java)
            intent.putExtra("fagner", Pessoa("Fagner Muniz"))
           startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        count++
        outState.putInt("ChaveDoContador",count)
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag,"$className - onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag,"$className - onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag,"$className - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag,"$className - onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag,"$className - onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag,"$className - onDestroy")
    }
}