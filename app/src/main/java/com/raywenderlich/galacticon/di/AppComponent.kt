package com.raywenderlich.galacticon.di

import android.content.Context
import com.raywenderlich.galacticon.views.photo.main.MainActivity
import com.raywenderlich.galacticon.views.photo.main.MainViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MainModule::class])
interface AppComponent {

    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(activity: MainActivity)
    fun inject(mainViewModel: MainViewModel)

}