package com.example.task_0

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import com.example.task_0.Singleton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.task_0.SecondActiviry

class MainActivity : AppCompatActivity() {
    lateinit var sp: SharedPreferences
    val APP_PREFERENCES = "mySettings"
    val SAVED_STRING = "stringHere"

    lateinit var et: EditText

    lateinit var str: String
    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et = findViewById(R.id.editText)

        val spBtn: Button = findViewById(R.id.button)
        val bundleBtn: Button = findViewById(R.id.button2)
        val singletonBtn: Button = findViewById(R.id.button3)

        spBtn.setOnClickListener {
            if (check())
            {
                str = et.text.toString()
                sp = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
                val editor: SharedPreferences.Editor = sp.edit()
                editor.putString(SAVED_STRING, str).apply()
                val intent = Intent(this, SecondActiviry::class.java)
                startActivityForResult(intent, 1)
            }
            else
            {
                Toast.makeText(this, "You did not enter any text!", Toast.LENGTH_SHORT).show()
            }
        }

        bundleBtn.setOnClickListener{
            if (check())
            {
                str = et.text.toString()
                val intent = Intent(this, SecondActiviry::class.java)
                val bundle = Bundle()
                bundle.putString("thestring", str)
                intent.putExtras(bundle)
                startActivityForResult(intent, 1)
            }
            else
            {
                Toast.makeText(this, "You did not enter any text!", Toast.LENGTH_SHORT).show()
            }
        }

        singletonBtn.setOnClickListener {
            if (check())
            {
                str = et.text.toString()
                //var instance: Singleton = Singleton.instance
                Singleton.instance.getInstance()
                if (Singleton.instance.InstanceExists())
                {
                    Singleton.instance.PutString(str)
                    val intent = Intent(this, SecondActiviry::class.java)
                    startActivityForResult(intent, 1)
                }
            }
            else
            {
                Toast.makeText(this, "You did not enter any text!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        outState.run {
            putString("thestring", et.text.toString())
        }
        super.onSaveInstanceState(outState)
    }

    fun check(): Boolean
    {
        if (et.text.toString().isNotEmpty())
        {
            return true
        }
        return false
    }
}