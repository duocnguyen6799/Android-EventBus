package com.example.eventbusinandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)
        supportActionBar?.title = "ACTIVITY 1"
        var btnGo:Button = findViewById(R.id.btnGo)
        btnGo.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,MainActivity2::class.java))
        })
    }
    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(msg:MessageEvent){
        if(msg.msg.equals("FINISH")){
            this.finish()
            Toast.makeText(applicationContext,"Main Activity 1 has been removed!", Toast.LENGTH_LONG).show()
        }
    }
    /* for event bus sticky
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    fun onEvent(msg:MessageEvent){
        if(msg.msg.equals("FINISH")){
            this.finish()
            Toast.makeText(applicationContext,msg.msg, Toast.LENGTH_LONG).show()
            EventBus.getDefault().removeAllStickyEvents();
            var messageEvent:MessageEvent = EventBus.getDefault().getStickyEvent(MessageEvent::class.java)
            EventBus.getDefault().removeStickyEvent(messageEvent)
        }
    }*/
}