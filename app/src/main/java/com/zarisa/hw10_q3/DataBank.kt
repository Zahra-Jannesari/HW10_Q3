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

    var hintList = mutableListOf(
        "در سریلانکا برای گفتن بله سرتان را تکان دهید.",
        "خیلی ها از شما بیشتر میدانند اما مهم این است که بتوانید از سفرتان لذت ببرید.",
        " سفر کردن به تنهایی هم می تواند جذابیت خودش را داشته باشد.",
        "هنگام ورود به خانه های کانادایی، باید کفش ها را درآورد.",
        "اگر قصد سفر دارید برای اینکه گرفتار شلوغی نشوید سحرخیز باشید.",
        "آهسته سفر کنید و از مسیر لذت ببرید!",
        "هنگام سفر از منطقه امن خود خارج شوید.",
        "چند کلمه از زبان شهری که به آنجا سفر می کنید بیاموزید.",
        "گاهی شاهانه سفر کنید.",
        "سبک سفر کنید.",
        "یک کفش سفری خوب به همراه داشته باشید.",
        "روند خرید و کارهای اداری سفر را کوتاه فرض نکنید.",
        "از فرهنگ و سبک زندگی مردم جایی که به آن سفر می کنید آگاه باشید.",
        "اختصاص دادن وقت بیش از حد برای عکاسی در سفر شما را از لذت تجربه اتفاقات بی بهره میسازد.",
        "به دنبال هتل هایی نزدیک دانشگاه ها بگردید.",
        "در سفر راجع به قیمت اجناس شک کنید.",
        "سعی کنید گویش های محلی را یاد بگیرید.",
        "به خاطر هزینه ها قید سفر را نزنید!",
        "در سفر دسته جمعی سلیقه های همه را در نظر بگیرید.",
        "برای بهتر سفر کردن آمادگی جسمانی خود را حفظ کنید."
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