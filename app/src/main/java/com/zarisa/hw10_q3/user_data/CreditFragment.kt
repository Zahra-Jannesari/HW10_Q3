package com.zarisa.hw10_q3.user_data

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.zarisa.hw10_q3.R
import com.zarisa.hw10_q3.databinding.FragmentCreditBinding

const val account = "account"
const val card = "card"
const val sheba = "sheba"
const val bank = "bankName"

class CreditFragment : Fragment() {
    private lateinit var binding: FragmentCreditBinding
    private var creditSharePref: SharedPreferences? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreditBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "اطلاعات بانکی"
        creditSharePref =
            this.activity?.getSharedPreferences("Credit Information", Context.MODE_PRIVATE)
        showInfoInView()
    }

    private fun showInfoInView() {
        binding.textViewUserAccount.text = creditSharePref?.getString(account, "")
        binding.textViewUserCard.text = creditSharePref?.getString(card, "")
        binding.textViewUserSheba.text = creditSharePref?.getString(sheba, "")

        var bankImage = when (creditSharePref?.getString(bank, "")) {
            "sepah" -> R.drawable.sepah
            "meli" -> R.drawable.meli
            "keshavarzi" -> R.drawable.keshavarzi
            else -> R.drawable.bank
        }
        binding.imageViewBankLogo.setImageResource(bankImage)
    }

}