package com.example.listview_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.listview_test.ui.notifications.ImageAdapter

class BookActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)

        val Title = intent.getStringExtra("Title")
        val Description = intent.getStringExtra("Description")
        val image: Int? = intent.extras?.getInt("Thumbnail")

        val tvtitle: TextView =findViewById(R.id.txttitle)
        val tvdescription: TextView = findViewById(R.id.txtdescrip)
        val tvcategory: TextView = findViewById(R.id.txtcateg)
        val img: ImageView = findViewById(R.id.bookthumbnail)

        tvtitle.setText(Title)
        tvdescription.setText(Description)
        if (image != null) {
            img.setImageResource(image)
        }

    }
}