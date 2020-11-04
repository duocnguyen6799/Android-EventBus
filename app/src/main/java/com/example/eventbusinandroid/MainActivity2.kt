package com.example.eventbusinandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.Toast
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportActionBar?.title = "ACTIVITY 2"
        var btnNext: Button = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,MainActivity3::class.java))
        })
    }


}