package com.zarisa.hw10_q3

import androidx.lifecycle.ViewModel

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
//    fun getUserBloodType():BloodType{
//        return DataBank.userBloodType
//    }
//    fun setUserName(newBloodType: BloodType){
//        DataBank.userBloodType=newBloodType
//    }
}
class ViewModelItems:ViewModel(){

}