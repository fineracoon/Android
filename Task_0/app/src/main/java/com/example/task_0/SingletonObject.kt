package com.example.task_0.com.example.task_0

object SingletonObject {
    var instance: SingletonObject = SingletonObject
    var value: String
        get() {
            TODO()
        }
        set(value) {}

    fun GetInstance(): SingletonObject
    {
        if (instance != null)
            instance = SingletonObject
        return instance
    }

    fun InstanceExists(): Boolean
    {
        if (instance != null)
            return true
        return  false
    }


}