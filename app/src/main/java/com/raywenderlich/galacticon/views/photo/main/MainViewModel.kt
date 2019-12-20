package com.raywenderlich.galacticon.views.photo.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.raywenderlich.galacticon.repository.ImageRequester
import com.raywenderlich.galacticon.model.Photo
import java.io.IOException
import java.util.ArrayList
import javax.inject.Inject


class MainViewModel @Inject constructor() : ImageRequester.ImageRequesterResponse {


    override fun receivedNewPhoto(newPhoto: Photo) {
       addNewPhoto(newPhoto)
    }

    private val _photoList = MutableLiveData<ArrayList<Photo>>()

    @Inject
    lateinit var imageRequester: ImageRequester

    val photosList: LiveData<ArrayList<Photo>>
        get() = _photoList

    fun init(){
        _photoList.value = ArrayList()
    }

    fun requestPhoto() {
        try {
            imageRequester.getPhoto()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun addNewPhoto(newPhoto: Photo){
        _photoList.postValue(arrayListOf(newPhoto))
        Log.d("heiner","adding photo ${_photoList.value?.size}")
    }
}