package com.example.task_0

import android.util.Log
import android.widget.Toast

class Singleton {
    companion object {
        var instance: Singleton = Singleton()
    }
    private lateinit var value: String

    public fun getInstance(): Singleton
    {
        if (instance == null)
            instance = Singleton()
        return instance
    }

    fun InstanceExists(): Boolean
    {
        if (instance == null)
            return false
        return true
    }

    public fun PutString(str: String?)
    {
        value = str.toString()
    }

    public fun GetString(): String
    {
        return value
    }
}