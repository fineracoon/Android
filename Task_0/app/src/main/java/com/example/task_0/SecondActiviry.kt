package com.example.task_0

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class SecondActiviry : AppCompatActivity() {
    lateinit var sp: SharedPreferences
    val APP_PREFERENCES = "mySettings"
    val SAVED_STRING = "stringHere"

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_activiry)

        val tv: TextView = findViewById(R.id.textView)
        val btnBack: Button = findViewById(R.id.button4)

        var bundle: Bundle

        sp = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
        if (sp.contains(SAVED_STRING))
        {
            tv.text = sp.getString(SAVED_STRING, "")
        }
        else if (Singleton.instance.InstanceExists())
        {
            tv.text = Singleton.instance.GetString()
        }
        else {
            bundle = getIntent().getExtras()!!
            if (bundle != null) {
                tv.text = bundle.get("thestring").toString()
            }
        }

        btnBack.setOnClickListener {
            if (sp.contains(SAVED_STRING))
            {
                sp.edit().clear().apply()
                finish()
            }
            else if (Singleton.instance.InstanceExists())
            {
                Toast.makeText(this, "singleton exists", Toast.LENGTH_LONG).show()
                //Singleton.instance = null
                finish()
            }
            else
            {
                bundle = getIntent().getExtras()!!
                bundle.remove("thestring")
                finish()
            }
        }
    }
}