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
    private lateinit var profileCreditSharePref: SharedPreferences

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
        profileCreditSharePref =
            requireActivity().getSharedPreferences("Credit Information", Context.MODE_PRIVATE)
        if (profileCreditSharePref.getString(account, "")!="" || profileCreditSharePref.getString(
                card, "")!="" || profileCreditSharePref.getString(sheba, "")!="" ){
            binding.textViewNotRegisterYet.visibility=View.GONE
            binding.scrollViewCredit.visibility=View.VISIBLE
            showInfoInView()
        }
    }

    private fun showInfoInView() {
        binding.textViewUserAccount.let { it.text = profileCreditSharePref.getString(account, "")
            if (it.text.isBlank())
                binding.cardViewAccount.visibility=View.GONE
        }
        binding.textViewUserCard.let { it.text = profileCreditSharePref.getString(card, "")
            if (it.text.isBlank())
                binding.cardViewCard.visibility=View.GONE
        }
        binding.textViewUserSheba.let { it.text = profileCreditSharePref.getString(sheba, "")
            if (it.text.isBlank())
                binding.cardViewSheba.visibility=View.GONE
        }
        var bankImage = when (profileCreditSharePref.getString(bank, "")) {
            "sepah" -> R.drawable.sepah
            "meli" -> R.drawable.meli
            "keshavarzi" -> R.drawable.keshavarzi
            else -> R.drawable.bank
        }
        binding.imageViewBankLogo.setImageResource(bankImage)
    }

}