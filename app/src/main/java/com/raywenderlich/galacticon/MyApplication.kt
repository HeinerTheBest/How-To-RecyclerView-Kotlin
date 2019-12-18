package com.raywenderlich.galacticon

import android.app.Application
import com.raywenderlich.galacticon.di.AppComponent
import com.raywenderlich.galacticon.di.DaggerAppComponent

class MyApplication : Application() {

    val appComponent: AppComponent by lazy {
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph
        DaggerAppComponent.factory().create(applicationContext)
    }
}