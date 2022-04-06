package com.zarisa.hw10_q3.setting_part

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.zarisa.hw10_q3.ViewModelProfile
import com.zarisa.hw10_q3.databinding.FragmentEditProfileBinding
import com.zarisa.hw10_q3.user_data.*

const val showProfileInfoInHome = "show"

class EditProfileFragment : Fragment() {
    private lateinit var profileCreditSharePref: SharedPreferences
    lateinit var binding: FragmentEditProfileBinding
    private val viewModelProfile: ViewModelProfile by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "تغییر اطلاعات شخصی"
        profileCreditSharePref =
            requireActivity().getSharedPreferences("user Information", Context.MODE_PRIVATE)
        setDataInEditTexts()
        binding.saveChangeButton.setOnClickListener { saveChanges() }
    }

    private fun setDataInEditTexts() {
        binding.name.setText(profileCreditSharePref.getString(name, ""))
        binding.id.setText(profileCreditSharePref.getString(nationalId, ""))
        binding.phone.setText(profileCreditSharePref.getString(phone, ""))
        binding.address.setText(profileCreditSharePref.getString(address, ""))
        binding.email.setText(profileCreditSharePref.getString(email, ""))
        binding.checkBoxInfoVisibilityInHome.isChecked =
            profileCreditSharePref.getBoolean(showProfileInfoInHome, false)
    }

    private fun saveChanges() {
        val editor = profileCreditSharePref.edit()
        editor.putString(name, binding.name.text.toString())
        editor.putString(nationalId,binding.id.text.toString())
        editor.putString(phone,binding.phone.text.toString())
        editor.putString(address,binding.address.text.toString())
        editor.putString(email,binding.email.text.toString())
        editor.putBoolean(showProfileInfoInHome,binding.checkBoxInfoVisibilityInHome.isChecked)
        Toast.makeText(requireContext(), "Changes saved.", Toast.LENGTH_SHORT).show()
        editor?.apply()
    }
}