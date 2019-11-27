package com.raywenderlich.galacticon

import android.app.Activity
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import java.io.IOException
import java.util.ArrayList

class MainViewModel {

    private val _photoList = MutableLiveData<ArrayList<Photo>>()
    private lateinit var imageRequester: ImageRequester


    val photosList: LiveData<ArrayList<Photo>>
        get() = _photoList



    fun init(activity: Activity){
        _photoList.value = ArrayList()
        imageRequester = ImageRequester(activity)
    }

    fun requestPhoto() {
        try {
            imageRequester.getPhoto()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    fun addNewPhoto(newPhoto: Photo){
        _photoList.value?.add(newPhoto)
        _photoList.value = _photoList.value
        Log.d("heiner","adding photo ${_photoList.value?.size}")
    }


}