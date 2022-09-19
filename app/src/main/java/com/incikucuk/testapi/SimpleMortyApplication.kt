package com.incikucuk.testapi
import android.app.Application
import android.content.Context

class SimpleMortyApplication: Application() {

    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}