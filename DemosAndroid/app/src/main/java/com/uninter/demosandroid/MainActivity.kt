package com.uninter.demosandroid

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var launcher: ActivityResultLauncher<Intent>
    private var filename: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnIntent).setOnClickListener{
            //Realizar uma ligação
//           callPhone()

            //Tirar foto
            takePicture()
        }

        initLauncher()
    }

    private fun initLauncher() {
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            try {
                if (it != null && it.resultCode == Activity.RESULT_OK) {
                    caseCapture()
                }
            } catch (e: Exception) {
                Log.e("Foto", e.toString())
            }
        }
    }
    private fun caseCapture() {
        filename.let {
            if (it != null) {
                val tempFile = File(it)
                findViewById<ImageView>(R.id.imgFoto).setImageURI(tempFile.toUri())
            }
        }
    }
    private fun takePicture(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED)
            {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                val image = CreateFile()

                val uri = FileProvider.getUriForFile(
                    this,
                    "com.uninter.demosandroid.provider",
                    image
                )

                filename = image.absolutePath.replace("/storage/emulated/0", "sdcard")
                intent.putExtra(MediaStore.EXTRA_OUTPUT, uri)

                launcher.launch(intent)
            }
            else
            {
                Log.d("permission", "permissão negada")
                requestPermissions(arrayOf(android.Manifest.permission.CAMERA),2)
            }
        }
    }
    private fun CreateFile(): File {
        val tempDir = File("${externalMediaDirs.first()}/Pictures")
        if(!tempDir.exists())
        {
            tempDir.mkdir()
        }

        return File.createTempFile("capture_",".png",tempDir)
    }
    private fun callPhone(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(checkSelfPermission(Intent.ACTION_CALL) == PackageManager.PERMISSION_GRANTED)
            {
                var myIntent = Intent(Intent.ACTION_CALL, Uri.parse("tel://41999999999"))
                startActivity(myIntent)
            }
            else
            {
                requestPermissions(arrayOf(android.Manifest.permission.CALL_PHONE),1)
            }
        }

    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 1) { //Telefone
            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED )
            {
                Toast.makeText(this,"permissão aceita", Toast.LENGTH_SHORT).show()

                var myIntent = Intent(Intent.ACTION_CALL, Uri.parse("tel://41999999999"))
                startActivity(myIntent)
            }
            else
            {
                Toast.makeText(this,"permissão negada", Toast.LENGTH_SHORT).show()
            }
        }
        else if (requestCode == 2) //Camera
        {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "permissão  concedida", Toast.LENGTH_SHORT).show()
                takePicture()
            } else {
                Toast.makeText(this, "permissão negada", Toast.LENGTH_SHORT).show()
            }
        }
    }

}