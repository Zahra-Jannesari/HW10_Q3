package com.zarisa.hw10_q3

import android.content.Context
import android.content.res.Resources


object DataBank {
    var showProfileInfoInHome: Boolean = false
    var profilePhotoUrl = R.drawable.profile_photo
    var userName: String = ""
    var userNationalID: String = ""
    var userPhone: String = ""
    var userAddress: String = ""
    var itemImages = arrayListOf(
        R.drawable.ali_ghapo,
        R.drawable.lotf_allah,
        R.drawable.chehel_soton,
        R.drawable.sadeq_school,
        R.drawable.monar,
        R.drawable.naqsh
    )
    var itemNames = arrayListOf(
        "عمارت عالی قاپو",
        "مسجد شیخ لطف الله",
        "کاخ چهل ستون",
        "مدرسه علمیه چهارباغ",
        "منار جنبان",
        "میدان نقش جهان"
    )
    var itemDescribe = arrayListOf(
//        Resources.getSystem().getString(R.string.Aali_Qapu),
//        ResourcesHelper.resources?.getString(R.string.app_name),
        R.string.Aali_Qapu,
        R.string.Lotfollah_Mosque,
        R.string.Chehel_Sotoon,
        R.string.Sadeq_School,
        R.string.Manar_Jonban,
        R.string.Naqsh_Jahan
    )

    var hintList = arrayListOf(
        "در سریلانکا برای گفتن بله سرتان را تکان دهید.",
        "خیلی ها از شما بیشتر میدانند اما مهم این است که بتوانید از سفرتان لذت ببرید.",
        " سفر کردن به تنهایی هم می تواند جذابیت خودش را داشته باشد.",
        "هنگام ورود به خانه های کانادایی، باید کفش ها را درآورد."
    )
    fun getDescribe(context: Context, index: Int): String {
        return context.resources.getString(itemDescribe[index - 1])
    }
//    var userBloodType:BloodType=BloodType.Unknown
}
//enum class BloodType{
//    APlus,AMinus,
//    BPlus,BMinus,
//    ABPlus,ABMinus,
//    OPlus,OMinus,
//    Unknown
//}