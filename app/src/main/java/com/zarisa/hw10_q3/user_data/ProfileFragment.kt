package com.zarisa.hw10_q3.user_data

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.zarisa.hw10_q3.ViewModelProfile
import com.zarisa.hw10_q3.databinding.FragmentProfileBinding
const val name="userName"
const val nationalId="id"
const val address="address"
const val phone="phone"
const val email="email"
class ProfileFragment : Fragment() {
    private lateinit var profileCreditSharePref: SharedPreferences
    lateinit var binding: FragmentProfileBinding
    private val viewModel: ViewModelProfile by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(false)
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profileCreditSharePref =
            requireActivity().getSharedPreferences("user Information", Context.MODE_PRIVATE)
        if (profileCreditSharePref.getString(name, "")!="" || profileCreditSharePref.getString(
                nationalId, "")!="" || profileCreditSharePref.getString(phone, "")!="" || profileCreditSharePref.getString(
                address, "")!=""||profileCreditSharePref.getString(email, "")!=""){
            binding.textViewNotRegisterYet.visibility=View.GONE
            binding.scrollViewProfile.visibility=View.VISIBLE
            setData()
        }
    }

    private fun setData() {
        viewModel.getPhoto(requireContext(), binding.imageView)
        binding.textViewUserName.let { it.text=profileCreditSharePref.getString(name, "")
        if (it.text.isBlank())
            binding.cardViewName.visibility=View.GONE
        }
        binding.textViewUserId.let { it.text=profileCreditSharePref.getString(nationalId, "")
            if (it.text.isBlank())
                binding.cardViewId.visibility=View.GONE
        }
        binding.textViewUserPhone.let { it.text=profileCreditSharePref.getString(phone, "")
            if (it.text.isBlank())
                binding.cardViewPhone.visibility=View.GONE
        }
        binding.textViewUserAddress.let { it.text=profileCreditSharePref.getString(address, "")
            if (it.text.isBlank())
                binding.cardViewAddress.visibility=View.GONE
        }
        binding.textViewUserEmail.let { it.text=profileCreditSharePref.getString(email, "")
            if (it.text.isBlank())
                binding.cardViewEmail.visibility=View.GONE
        }
    }
}