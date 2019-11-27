package com.raywenderlich.galacticon

import android.app.Activity
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import java.io.IOException
import java.util.ArrayList

class MainViewModel: ImageRequester.ImageRequesterResponse {

    override fun receivedNewPhoto(newPhoto: Photo) {
       addNewPhoto(newPhoto)
    }

    private val _photoList = MutableLiveData<ArrayList<Photo>>()
    private val _photo     = MutableLiveData<Photo>()

    private lateinit var imageRequester: ImageRequester


    val photosList: LiveData<ArrayList<Photo>>
        get() = _photoList



    fun init(){
        _photoList.value = ArrayList()
        imageRequester = ImageRequester(this)
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
        Log.d("heiner","adding photo ${_photoList.value?.size}")
    }


}