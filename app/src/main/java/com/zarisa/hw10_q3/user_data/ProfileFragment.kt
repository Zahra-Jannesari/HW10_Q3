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
        setData()
    }

    private fun setData() {
        binding.textViewUserName.text = profileCreditSharePref.getString(name, "")
        binding.textViewUserId.text = profileCreditSharePref.getString(nationalId, "")
        binding.textViewUserPhone.text = profileCreditSharePref.getString(address, "")
        binding.textViewUserAddress.text = profileCreditSharePref.getString(phone, "")
        binding.textViewUserEmail.text= profileCreditSharePref.getString(email, "")
        viewModel.getPhoto(requireContext(), binding.imageView)
    }
}