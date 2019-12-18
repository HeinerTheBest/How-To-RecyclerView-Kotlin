package com.raywenderlich.galacticon.di

import com.raywenderlich.galacticon.repository.ImageRequester
import com.raywenderlich.galacticon.views.photo.main.MainViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class MainModule {

    @Binds
    abstract fun provideImageRequester(storage : MainViewModel) : ImageRequester.ImageRequesterResponse


}