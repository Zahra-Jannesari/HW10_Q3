package com.zarisa.hw10_q3

object DataBank {
    var profilePhotoUrl = R.drawable.profile_photo
    var userName: String = ""
    var userNationalID: Int = 0
    var userPhone: Int = 0
    var userAddress: String = ""


    var itemImages = arrayListOf(
        R.drawable.ali_ghapo,
        R.drawable.lotf_allah,
        R.drawable.chehel_soton,
        R.drawable.sadeq_school,
        R.drawable.monar,
        R.drawable.naqsh
    )
    var itemNames =
        arrayListOf(
            "عمارت عالی قاپو",
            "مسجد شیخ لطف الله",
            "کاخ چهل ستون",
            "مدرسه علمیه چهارباغ",
            "منار جنبان",
            "میدان نقش جهان"
        )
    var itemDescribe = arrayListOf(
        R.string.Aali_Qapu,
        R.string.Lotfollah_Mosque,
        R.string.Chehel_Sotoon,
        R.string.Sadeq_School,
        R.string.Naqsh_Jahan
    )
//    var userBloodType:BloodType=BloodType.Unknown
}
//enum class BloodType{
//    APlus,AMinus,
//    BPlus,BMinus,
//    ABPlus,ABMinus,
//    OPlus,OMinus,
//    Unknown
//}