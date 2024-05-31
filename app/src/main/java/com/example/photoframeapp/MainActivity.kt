package com.example.photoframeapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

   var currentimg = 0;
   lateinit var image : ImageView
   var names = arrayOf("CASPER & COCO", "COCO", "CASPER", "COCO")
   var para = arrayOf("Casper, the playful male cat, sports soft, white fur and curious blue eyes. He loves chasing toys and snuggling on laps.\n" +
           "Coco, the sleek female cat, flaunts glossy black fur and confident green eyes. She's adventurous, climbing high and basking in the sun, but also enjoys cuddles.\n" +
           "Both cats, with their distinct personalities, bring joy to their home.", "Another glimpse of COCO", "Another glimpse of casper", "COCO again" )
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val prev = findViewById<ImageButton>(R.id.imgprev)
        val next = findViewById<ImageButton>(R.id.imgnext)
        val text = findViewById<TextView>(R.id.textView2)
        val text2 = findViewById<TextView>(R.id.textView)

        prev.setOnClickListener{

            val idCurrentImageString = "pic$currentimg"
            //get string id into integer address associated with it
           val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)

           image = findViewById(idCurrentImageInt)
            image.alpha= 0f

            currentimg = (4+ currentimg-1)%4
            val idImageToShowString = "pic$currentimg"
            //get string id into integer address associated with it
            val idImageToShowInt = this.resources.getIdentifier(idImageToShowString, "id", packageName)

            image = findViewById(idImageToShowInt)
            image.alpha= 1f
            text.text = names[currentimg]
            text2.text = para[currentimg]
        }

        next.setOnClickListener {
            val idCurrentImageString = "pic$currentimg"
            //get string id into integer address associated with it
            val idCurrentImageInt =
                this.resources.getIdentifier(idCurrentImageString, "id", packageName)

            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentimg = (4 + currentimg + 1) % 4
            val idImageToShowString = "pic$currentimg"
            //get string id into integer address associated with it
            val idImageToShowInt =
                this.resources.getIdentifier(idImageToShowString, "id", packageName)

            image = findViewById(idImageToShowInt)
            image.alpha = 1f
            text.text = names[currentimg]
            text2.text = para[currentimg]
        }

    }
}