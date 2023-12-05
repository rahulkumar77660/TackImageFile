package com.example.tackimage

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var userImage : de.hdodenhof.circleimageview.CircleImageView

    @SuppressLint("MissingInflatedId")
    companion object{
        val IMAGE_REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userImage  = findViewById(R.id.userImage)
        val upload_btn : Button = findViewById(R.id.upload_btn)

        upload_btn.setOnClickListener {
            this.pickImageGalary()
        }
    }
    fun pickImageGalary(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode ==RESULT_OK) {
            userImage.setImageURI(data?.data)
        }
    }
}