package com.raywenderlich.galacticon

import android.app.Activity
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import java.io.IOException
import java.util.ArrayList

class MainViewModel : ImageRequester.ImageRequesterResponse   {

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

    override fun receivedNewPhoto(newPhoto: Photo) {
        _photoList.value?.add(newPhoto)
    }

}