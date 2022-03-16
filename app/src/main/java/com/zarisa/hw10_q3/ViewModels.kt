package com.zarisa.hw10_q3

import android.content.Context
import android.widget.ImageView
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.zarisa.hw10_q3.DataBank.photoUrl

class ViewModelProfile:ViewModel(){
    fun getUserName():String{
        return DataBank.userName
    }
    fun setUserName(newName:String){
        DataBank.userName=newName
    }
    fun getUserId():Int{
        return DataBank.userNationalID
    }
    fun setUserId(newId:Int){
        DataBank.userNationalID=newId
    }
    fun getUserPhone():Int{
        return DataBank.userPhone
    }
    fun setUserName(newPhone:Int){
        DataBank.userPhone=newPhone
    }
    fun getUserAddress():String{
        return DataBank.userAddress
    }
    fun setUserAddress(newAddress:String){
        DataBank.userAddress=newAddress
    }
    fun getPhoto(context: Context, imageView: ImageView){

        val url = if (DataBank.photoUrl != null) "$DataBank.photoUrl?w=360" else null //1
        Glide.with(context)  //2
            .load(photoUrl) //3
            .centerCrop() //4
//            .placeholder(R.drawable.holder) //5
//            .error(R.drawable.error) //6
            .into(imageView)
    }
//    fun getUserBloodType():BloodType{
//        return DataBank.userBloodType
//    }
//    fun setUserName(newBloodType: BloodType){
//        DataBank.userBloodType=newBloodType
//    }
}
class ViewModelItems:ViewModel(){

}