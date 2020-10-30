package com.example.task_0

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.example.task_0.com.example.task_0.SingletonObject

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
/*
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
                navigate(R.id.action_mainFragment_to_secondFragment)
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
                val bundle = Bundle()
                bundle.putString("thestring", str)
                navController.navigate(R.id.action_mainFragment_to_secondFragment, bundle)
            }
            else
            {
                Toast.makeText(this, "You did not enter any text!", Toast.LENGTH_SHORT).show()
            }
        }

        singletonBtn.setOnClickListener {
            if (check()) {
                str = et.text.toString()
                SingletonObject.instance.GetInstance()
                //Singleton.instance.getInstance()
                if (SingletonObject.instance.InstanceExists()) //(Singleton.instance.InstanceExists())
                {
                    SingletonObject.instance.value = str
                    navController.navigate(R.id.action_mainFragment_to_secondFragment)
                }
            } else {
                Toast.makeText(this, "You did not enter any text!", Toast.LENGTH_SHORT).show()
            }
        }*/
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