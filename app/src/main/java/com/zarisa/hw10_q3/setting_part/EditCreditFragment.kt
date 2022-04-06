package com.zarisa.hw10_q3.setting_part

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.zarisa.hw10_q3.*
import com.zarisa.hw10_q3.databinding.FragmentEditCreditBinding
import com.zarisa.hw10_q3.user_data.account
import com.zarisa.hw10_q3.user_data.bank
import com.zarisa.hw10_q3.user_data.card
import com.zarisa.hw10_q3.user_data.sheba

class EditCreditFragment : Fragment() {
    private lateinit var binding: FragmentEditCreditBinding
    private var profileCreditSharePref: SharedPreferences? = null
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
        profileCreditSharePref =
            this.activity?.getSharedPreferences("user Information", Context.MODE_PRIVATE)
        putDataInEditTexts()
        binding.saveChangeButton.setOnClickListener { saveBtnClick() }
    }

    private fun putDataInEditTexts() {
        binding.account.setText(profileCreditSharePref?.getString(account, ""))
        binding.card.setText(profileCreditSharePref?.getString(card, ""))
        binding.sheba.setText(profileCreditSharePref?.getString(sheba, ""))
        var bankName = profileCreditSharePref?.getString(bank, "")
        when (bankName) {
            "meli" -> binding.rbtnMeli.isChecked = true
            "sepah" -> binding.rbtnSepah.isChecked = true
            "keshavarzi" -> binding.rbtnKeshavarzi.isChecked = true
            else -> binding.rbtnNone.isChecked = true
        }
    }

    private fun saveBtnClick() {
        val editor = profileCreditSharePref?.edit()
        var bankName = when (binding.rgBanks.checkedRadioButtonId) {
            R.id.rbtn_meli -> "meli"
            R.id.rbtn_sepah -> "sepah"
            R.id.rbtn_keshavarzi -> "keshavarzi"
            else -> ""
        }
        editor?.putString(bank, bankName)

        editor?.putString(account, binding.account.text.toString())
        editor?.putString(card, binding.card.text.toString())
        editor?.putString(sheba, binding.sheba.text.toString())
        editor?.apply()
    }
}