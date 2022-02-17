package com.example.homework2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.URLUtil
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val urlOfPhoto = mutableListOf(
            "https://github.com/bumptech/glide/raw/master/static/glide_logo.png",
            "https://imgv3.fotor.com/images/videoImage/apply-photo-effects_2021-06-18-091040.png",
            "https://imgv3.fotor.com/images/side/Delete-Backgrounds-with-High-Quality.jpg",
            "https://imgv3.fotor.com/images/side/Background-remover-sideimage-b.png"
        )
        submit_url.setOnClickListener {
            if (checkEditTExt()) {
                urlOfPhoto.add(for_url.text.toString())
            }
        }

        show_randomly.setOnClickListener {
            Toast.makeText(this, "Wait just a minut", Toast.LENGTH_SHORT).show()
            Glide.with(applicationContext)
                .load(getRandom(urlOfPhoto))
                .into(to_show)
        }
    }

    private fun checkEditTExt(): Boolean {
        if (for_url.text.toString() == "") {
            Toast.makeText(this, "Sorry can not be empty!", Toast.LENGTH_SHORT).show()
            return false
        } else {
            return if (URLUtil.isValidUrl(for_url.text.toString())) {
                if (isPhoto(for_url.text.toString())){
                    Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show()
                    true
                } else{
                    Toast.makeText(this,"Sorry this is not photo!", Toast.LENGTH_SHORT).show()
                    false
                }
            } else {
                Toast.makeText(this, "Sorry this not url!", Toast.LENGTH_SHORT).show()
                false
            }
        }
    }
}