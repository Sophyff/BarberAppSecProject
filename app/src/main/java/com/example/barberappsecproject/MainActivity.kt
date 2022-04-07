package com.example.barberappsecproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import com.example.barberappsecproject.ui.dashboard.DashboardActivity
import com.example.barberappsecproject.ui.login.LoginActivity

class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val pref = getSharedPreferences("User", MODE_PRIVATE)

            if(pref.contains("name")) {
                handler.sendEmptyMessageDelayed(MESSAGE_GOTO_DASHBOARD, 5000)
            } else {
                handler.sendEmptyMessageDelayed(MESSAGE_GOTO_LOGIN, 5000)
            }
        }

        val handler = @SuppressLint("HandlerLeak")
        object: Handler() {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                if(msg.what == MESSAGE_GOTO_DASHBOARD) {
                    startActivity(Intent(baseContext, DashboardActivity::class.java))
                    finish()
                } else if(msg.what == MESSAGE_GOTO_LOGIN) {
                    startActivity(Intent(baseContext, LoginActivity::class.java))
                    finish()
                }
            }
        }

        companion object {
            const val MESSAGE_GOTO_LOGIN = 1
            const val MESSAGE_GOTO_DASHBOARD = 2
        }
}