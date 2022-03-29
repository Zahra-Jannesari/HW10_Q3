package com.zarisa.hw10_q3

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.zarisa.hw10_q3.databinding.FragmentEditCreditBinding

class EditCreditFragment : Fragment() {
    private lateinit var binding:FragmentEditCreditBinding
    private var creditSharePref: SharedPreferences? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditCreditBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "تغییر اطلاعات بانکی"
        creditSharePref = this.activity?.getSharedPreferences("Credit Information", Context.MODE_PRIVATE)
        putDataInEditTexts()
        binding.saveChangeButton.setOnClickListener { saveBtnClick() }
    }

    private fun putDataInEditTexts() {
        TODO("Not yet implemented")
    }

    private fun saveBtnClick() {
        val editor = creditSharePref?.edit()
        var bankName=when(binding.rgBanks.checkedRadioButtonId){
            R.id.rbtn_meli->"meli"
            R.id.rbtn_sepah->"sepah"
            R.id.rbtn_keshavarzi->"keshavarzi"
            else->""
        }
        editor?.putString(bank,"")

        editor?.putString(account,binding.account.text.toString())
        editor?.putString(card,binding.card.text.toString())
        editor?.putString(sheba,binding.sheba.text.toString())
        editor?.apply()
    }
}