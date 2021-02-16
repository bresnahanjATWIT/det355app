package com.example.det355app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class MainActivity : AppCompatActivity() {
    private lateinit var ref : DatabaseReference
    private var clickNum = 0
    private lateinit var textView : TextView
    private lateinit var x : number


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById<TextView>(R.id.textView1)
        x = number()
        ref = FirebaseDatabase.getInstance().getReference().child("number")
        val Button = findViewById<Button>(R.id.button)
        Button.setOnClickListener {
            clickNum++
            textView.text = clickNum.toString()
            x.setNum(clickNum)
            ref.push().setValue(x)
        }
    }
}