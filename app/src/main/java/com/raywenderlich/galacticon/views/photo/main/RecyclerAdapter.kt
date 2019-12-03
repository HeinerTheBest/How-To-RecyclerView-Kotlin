package com.raywenderlich.galacticon.views.photo.main

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.raywenderlich.galacticon.R
import com.raywenderlich.galacticon.inflate
import com.raywenderlich.galacticon.model.Photo
import com.raywenderlich.galacticon.views.photo.PhotoActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recyclerview_item_row.view.*

class RecyclerAdapter(private val photos: ArrayList<Photo>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflateView = parent.inflate(R.layout.recyclerview_item_row)
        return ViewHolder(inflateView)
    }

    override fun getItemCount() = photos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemPhoto = photos[position]
        holder.bindPhoto(itemPhoto)
    }


  class ViewHolder(v : View) : RecyclerView.ViewHolder(v) , View.OnClickListener {
      private var view : View = v
      private var photo : Photo? = null

      init {
          v.setOnClickListener(this)
      }

      override fun onClick(v: View?) {
          val context = itemView.context
          val showPhotoIntent = Intent(context, PhotoActivity::class.java)
          showPhotoIntent.putExtra(PHOTO_KEY, photo)
          context.startActivity(showPhotoIntent)
      }

      companion object{
          private val PHOTO_KEY = "PHOTO"
      }

      fun bindPhoto(photo: Photo){
          this.photo = photo
          Picasso.with(view.context).load(photo.url).into(view.itemImage)
          view.itemDate.text = photo.humanDate
          view.itemDescription.text = photo.explanation
      }
  }


}
