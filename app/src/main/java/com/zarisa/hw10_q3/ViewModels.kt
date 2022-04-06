package com.zarisa.hw10_q3

import android.content.Context
import android.widget.ImageView
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.zarisa.hw10_q3.DataBank.profilePhotoUrl

class ViewModelProfile : ViewModel() {
    fun getPhoto(context: Context, imageView: ImageView) {
        val url = if (profilePhotoUrl != null) profilePhotoUrl else null
        Glide.with(context)
            .load(url)
            .centerCrop()
            .transform(CircleCrop())
//            .placeholder(R.drawable.holder)
//            .error(R.drawable.error)
            .into(imageView)
    }
//    fun getUserBloodType():BloodType{
//        return DataBank.userBloodType
//    }
//    fun setUserName(newBloodType: BloodType){
//        DataBank.userBloodType=newBloodType
//    }
}

class ViewModelHomeItems : ViewModel() {
    fun getItemImage(context: Context, imageView: ImageView, itemNumber: Int) {
        val url = DataBank.itemImages[itemNumber - 1]
        Glide.with(context)
            .load(url)
            .centerCrop()
            .transform(CircleCrop())
//            .placeholder(R.drawable.holder)
//            .error(R.drawable.error)
            .into(imageView)
    }

    fun getItemFullImage(context: Context, imageView: ImageView, itemNumber: Int) {
        val url = DataBank.itemImages[itemNumber - 1]
        Glide.with(context)
            .load(url)
            .centerCrop()
//            .placeholder(R.drawable.holder)
//            .error(R.drawable.error)
            .into(imageView)
    }

    fun getItemName(itemNumber: Int): String {
        return DataBank.itemNames[itemNumber - 1]
    }

    fun getItemDescribe(context: Context, itemNumber: Int): String {
        return DataBank.getDescribe(context, itemNumber)
    }

    fun getHint(): String {
        DataBank.hintList.shuffle()
        return DataBank.hintList[0]
    }
}