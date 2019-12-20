package com.raywenderlich.galacticon.di

import com.raywenderlich.galacticon.repository.ImageRequester
import com.raywenderlich.galacticon.views.photo.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class MainModule {


    @Provides
    fun provideImageRequester(): ImageRequester.ImageRequesterResponse {
        return MainViewModel()
    }



}